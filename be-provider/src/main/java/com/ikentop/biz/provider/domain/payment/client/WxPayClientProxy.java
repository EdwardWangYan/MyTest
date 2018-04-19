package com.ikentop.biz.provider.domain.payment.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wxpay.sdk.WXPay;
import com.ikentop.biz.provider.domain.payment.PaymentClient;
import com.ikentop.biz.provider.domain.payment.PaymentProperties;
import com.ikentop.biz.provider.domain.payment.constant.WxPayTradeType;
import com.ikentop.biz.provider.domain.payment.exception.PaymentCreationException;
import com.ikentop.biz.provider.domain.payment.exception.PaymentRefundException;
import com.ikentop.biz.provider.domain.payment.exception.WxPaymentException;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;
import com.ikentop.biz.provider.domain.payment.pojo.WxPayPagePaymentCreateRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.WxPayPaymentRefundRequestExt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author tac
 * @since 04/01/2018
 */
public class WxPayClientProxy implements PaymentClient {
    public static final String WX_PAY_SUCCESS_CODE = "SUCCESS";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PaymentProperties paymentProperties;
    private WXPay client;
    private Boolean sandbox = false;

    public WxPayClientProxy(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
        init();
    }

    private void init() {
        sandbox = paymentProperties.getSandbox();
        logger.debug("准备初始化微信支付客户端");
        logger.debug("当前环境：{}", sandbox ? "沙箱环境" : "正式环境");
        if (sandbox) {
            logger.warn("微信支付暂不支付沙箱环境，将切换到正式环境");
            sandbox = false;
        }

        String appId;
        String mchId;
        String appSecret;
        String certPath;

        if (!sandbox) {
            appId = paymentProperties.getWxPay().getAppId();
            mchId = paymentProperties.getWxPay().getMchId();
            appSecret = paymentProperties.getWxPay().getAppSecret();
            certPath = paymentProperties.getWxPay().getCertPath();
        } else {
            throw new RuntimeException("");
        }
        if (StringUtils.isBlank(appId)) {
            logger.warn("微信支付AppID不能为空，在正确配置前客户端将无法正常使用");
        }
        if (StringUtils.isBlank(mchId)) {
            logger.warn("微信支付商户号（mch id）不能为空，在正确配置前客户端将无法正常使用");
        }
        if (StringUtils.isBlank(appSecret)) {
            logger.warn("微信支付密钥（app secret）不能为空，在正确配置前客户端将无法正常使用");
        }
        if(StringUtils.isBlank(certPath)){
            logger.warn("微信支付安全证书路径（cert path）不能为空，在正确配置前客户端某些功能（如退款）将无法正常使用");
        }
        client = new CustomWXPayClient(new CustomWXPayClient.SimpleWXPayConfig(appId, mchId, appSecret, certPath));

        logger.info("初始化微信支付客户端完成");
    }

    /**
     * 对应微信扫码支付
     */
    @Override
    public String createPagePayment(PagePaymentCreateRequest request) throws PaymentCreationException {
        checkCreatePagePaymentRequest(request);
        WxPayPagePaymentCreateRequestExt ext = (WxPayPagePaymentCreateRequestExt) request.getExt();

        logger.debug("准备请求创建微信支付网页支付交易订单");

        logger.debug("---填充请求参数---");
        Map<String, String> data = new HashMap<>();
        logger.debug("设置商户订单号");
        data.put("out_trade_no", request.getBizOrderNo());
        logger.trace("out trade no: {}", request.getBizOrderNo());
        logger.debug("设置订单总金额");
        setTotalFee(request, data);
        logger.trace("total fee: {}", request.getTotalAmount());
        logger.debug("设置订单金额类型");
        data.put("fee_type", ext.getFeeType());
        logger.trace("fee type: {}", ext.getFeeType());
        logger.debug("设置订单内容");
        data.put("body", ext.getBody());
        logger.trace("body: {}", ext.getBody());
        logger.debug("设置订单详情");
        data.put("detail", ext.getDetail());
        logger.trace("detail: {}", ext.getDetail());
        logger.debug("设置支付回调url");
        String notifyUrl = paymentProperties.getDomain() + "/" + request.getNotifyUrl();
        data.put("notify_url", notifyUrl);
        logger.trace("notify url: {}", notifyUrl);
        logger.debug("设置交易方式");
        data.put("trade_type", WxPayTradeType.NATIVE.getVal());
        logger.trace("trade type: {}", WxPayTradeType.NATIVE.getVal());
        logger.debug("设置商品id");
        data.put("product_id", ext.getProductId());
        logger.trace("product id: {}", ext.getProductId());
        logger.debug("---填充请求参数完成---");

        try {
            logger.debug("发起请求（{}）", sandbox ? "沙箱环境" : "正式环境");
            Map<String, String> resp = client.unifiedOrder(data);
            logger.trace("response data: {}", resp);
            logger.debug("请求完成");
            if (!resp.get("return_code").equals(WX_PAY_SUCCESS_CODE)) {
                logger.error("微信支付请求发生异常");
                throw new WxPaymentException(resp.get("return_code"), resp.get("return_msg"));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(resp);
        } catch (Exception e) {
            throw new PaymentCreationException("创建微信支付交易订单失败", e);
        }
    }

    @Override
    public String refund(PaymentRefundRequest request) throws PaymentRefundException {
        logger.debug("准备请求微信支付退款");
        WxPayPaymentRefundRequestExt ext = (WxPayPaymentRefundRequestExt) request.getExt();
        Map<String, String> resp = new HashMap<>();

        logger.debug("---填充请求参数---");
        logger.debug("设置订单号");
        if (request.getTradeNo() != null) {
            logger.debug("使用微信支付订单号进行退款");
            resp.put("transaction_id", request.getTradeNo());
            logger.trace("transaction id: {}", request.getTradeNo());
        } else if (request.getBizOrderNo() != null) {
            logger.debug("使用商户订单号进行退款");
            resp.put("out_trade_no", request.getBizOrderNo());
            logger.trace("out trade no: {}", request.getBizOrderNo());
        }
        logger.debug("设置商户退款订单号");
        resp.put("out_refund_no", ext.getRefundNo());
        logger.trace("out refund no: {}", ext.getRefundNo());
        logger.debug("设置交易订单总金额");
        resp.put("total_fee", ext.getTotalFee());
        logger.trace("total fee: {}", ext.getTotalFee());
        logger.debug("设置退款金额");
        resp.put("refund_fee", request.getRefundFee());
        logger.trace("refund fee: {}", request.getRefundFee());
        logger.debug("设置退款说明");
        resp.put("refund_desc", ext.getRefundDesc());
        logger.trace("refund desc: {}", ext.getRefundDesc());
        logger.debug("---填充请求参数完成---");
        try {
            logger.debug("准备发起请求");
            Map<String, String> response = client.refund(resp);
            String str = new ObjectMapper().writeValueAsString(response);
            logger.trace("response: {}", str);
            return str;
        } catch (Exception e) {
            throw new PaymentRefundException("请求微信支付退款失败", e);
        }
    }

    private void setTotalFee(PagePaymentCreateRequest request, Map<String, String> data) {
        if (paymentProperties.getSandbox()) {
            logger.debug("由于微信支付暂不支持沙箱环境，将指定订单总价为0.01元方便测试");
            logger.debug("原金额：{}", request.getTotalAmount());
            data.put("total_fee", "1");
        } else {
            data.put("total_fee", request.getTotalAmount());
        }
    }

    private void checkCreatePagePaymentRequest(PagePaymentCreateRequest request) {
        //todo::
        checkCreatePagePaymentRequestExt((WxPayPagePaymentCreateRequestExt) request.getExt());
    }

    private void checkCreatePagePaymentRequestExt(WxPayPagePaymentCreateRequestExt ext) {
        checkArgument(StringUtils.isNotBlank(ext.getProductId()), "product id");
    }
}
