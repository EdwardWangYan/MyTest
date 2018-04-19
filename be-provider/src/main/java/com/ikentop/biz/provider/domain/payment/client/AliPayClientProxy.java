package com.ikentop.biz.provider.domain.payment.client;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikentop.biz.provider.domain.payment.PaymentClient;
import com.ikentop.biz.provider.domain.payment.PaymentProperties;
import com.ikentop.biz.provider.domain.payment.exception.PaymentCreationException;
import com.ikentop.biz.provider.domain.payment.exception.PaymentRefundException;
import com.ikentop.biz.provider.domain.payment.pojo.AliPayPagePaymentCreateRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.AliPayPaymentRefundRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author tac
 * @since 04/01/2018
 */
public class AliPayClientProxy implements PaymentClient {
    public static final String ALIPAY_SANDBOX_GATEWAY = "https://openapi.alipaydev.com/gateway.do";
    public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PaymentProperties paymentProperties;

    private AlipayClient client;

    public AliPayClientProxy(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
        init();
    }

    private void init() {
        logger.debug("准备初始化支付宝支付客户端");
        Boolean sandbox = paymentProperties.getSandbox();
        logger.debug("当前环境：{}", sandbox ? "沙箱环境" : "正式环境");

        String appId = sandbox ? paymentProperties.getAliPay().getSandbox().getAppId() : paymentProperties.getAliPay().getAppId();
        String privateKey = sandbox ? paymentProperties.getAliPay().getSandbox().getPrivateKey() : paymentProperties.getAliPay().getPrivateKey();
        String gateway = sandbox ? ALIPAY_SANDBOX_GATEWAY : ALIPAY_GATEWAY;

        if (StringUtils.isBlank(appId)) {
            logger.warn("支付宝appId为空，在正确配置前客户端将无法正常使用");
        }
        if (StringUtils.isBlank(privateKey)) {
            logger.warn("支付宝应用私钥为空，在正确配置前客户端将无法正常使用");
        }

        client = new DefaultAlipayClient(gateway, appId, privateKey);
        logger.info("初始化支付宝支付客户端完成");
    }

    /**
     * 对应支付宝网页支付
     */
    @Override
    public String createPagePayment(PagePaymentCreateRequest request) throws PaymentCreationException {
        checkCreatePagePaymentRequest(request);
        ObjectMapper objectMapper = new ObjectMapper();
        AliPayPagePaymentCreateRequestExt ext = (AliPayPagePaymentCreateRequestExt) request.getExt();
        logger.debug("准备请求创建支付宝网页支付交易订单");
        AlipayTradePagePayRequest aliRequest = new AlipayTradePagePayRequest();

        logger.debug("---填充请求参数---");
        if (StringUtils.isNotBlank(ext.getReturnUrl())) {
            logger.debug("配置支付成功跳转url");
            String returnUrl = ext.getReturnUrl();
            aliRequest.setReturnUrl(returnUrl);
            logger.trace("return url: {}", returnUrl);
            logger.debug("填充业务请求参数");
            aliRequest.setBizContent(request.getAttachment());
            logger.trace("biz content: {}", request.getAttachment());
        } else {
            logger.warn("检测到未指定return url，可能会导致支付流程不完整");
        }
        if (StringUtils.isNotBlank(request.getNotifyUrl())) {
            logger.debug("配置支付宝回调通知url");
            String notifyUrl = paymentProperties.getDomain() + "/" + request.getNotifyUrl();
            aliRequest.setNotifyUrl(notifyUrl);
            logger.trace("notify url: {}", notifyUrl);
        } else {
            logger.warn("检测到未指定notify url，可能会导致支付流程不完整");
        }
        logger.debug("---填充请求参数完成---");

        logger.debug("---填充支付参数---");
        AlipayTradePagePayModel bizModel = new AlipayTradePagePayModel();
        logger.debug("填充商户订单号");
        bizModel.setOutTradeNo(request.getBizOrderNo());
        logger.trace("out trade no: {}", request.getBizOrderNo());
        logger.debug("指定产品CODE");
        //todo:: product code
        String productCode = "FAST_INSTANT_TRADE_PAY";
        bizModel.setProductCode(productCode);
        logger.trace("product code: {}", productCode);
        logger.debug("填充订单金额");
        bizModel.setTotalAmount(request.getTotalAmount());
        logger.trace("total amount: {}", request.getTotalAmount());
        logger.debug("填充商品名称");
        bizModel.setSubject(ext.getSubject());
        logger.trace("subject: {}", ext.getSubject());
        logger.debug("填充商品描述");
        bizModel.setBody(ext.getBody());
        logger.trace("body: {}", ext.getBody());
        logger.debug("---填充支付参数完成---");
        try {
            logger.trace("支付参数最终结果（json格式）：{}", objectMapper.writeValueAsString(bizModel));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        aliRequest.setBizModel(bizModel);

        String form = "";
        try {
            logger.debug("发起请求（{}），生成表单", paymentProperties.getSandbox() ? "沙箱环境" : "正式环境");
            form = client.pageExecute(aliRequest).getBody();
            logger.debug("请求完成");
        } catch (AlipayApiException e) {
            throw new PaymentCreationException("创建支付宝支付交易订单失败", e);
        }
        return form;
    }

    @Override
    public String refund(PaymentRefundRequest request) throws PaymentRefundException {
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        AliPayPaymentRefundRequestExt ext = (AliPayPaymentRefundRequestExt) request.getExt();
        logger.debug("准备请求支付宝订单退款");
        Map<String, String> content = new HashMap<>();
        logger.debug("设置支付宝订单号");
        content.put("trade_no", request.getTradeNo());
        logger.trace("trade no: {}", request.getTradeNo());
        logger.debug("设置商户订单号");
        content.put("out_trade_no", request.getBizOrderNo());
        logger.trace("out trade no: {}", request.getBizOrderNo());
        logger.debug("设置退款金额");
        content.put("refund_amount", request.getRefundFee());
        logger.trace("refund amount: {}", request.getRefundFee());
        try {
            alipayRequest.setBizContent(new ObjectMapper().writeValueAsString(content));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        AlipayTradeRefundResponse response;
        try {
            response = client.execute(alipayRequest);
        } catch (AlipayApiException e) {
            throw new PaymentRefundException("执行支付宝退款操作失败", e);
        }
        if ("10000".equals(response.getCode())) {
            logger.debug("退款成功");
        } else {
            logger.debug("退款失败：{}", response.getSubMsg());
            throw new PaymentRefundException(response.getSubMsg());
        }
        try {
            String rStr = new ObjectMapper().writeValueAsString(response);
            logger.trace("response: {}", rStr);
            return "success";
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkCreatePagePaymentRequest(PagePaymentCreateRequest request) {
        Objects.requireNonNull(request.getBizOrderNo());
        Objects.requireNonNull(request.getTotalAmount());
        checkCreatePagePaymentRequestExt((AliPayPagePaymentCreateRequestExt) request.getExt());
    }

    private void checkCreatePagePaymentRequestExt(AliPayPagePaymentCreateRequestExt ext) {
        Objects.requireNonNull(ext.getSubject());
        Objects.requireNonNull(ext.getBody());
    }
}
