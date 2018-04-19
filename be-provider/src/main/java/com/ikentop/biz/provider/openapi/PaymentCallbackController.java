package com.ikentop.biz.provider.openapi;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.common.base.Charsets;
import com.ikentop.biz.provider.domain.payment.PaymentProperties;
import com.ikentop.biz.provider.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tac
 * @since 04/01/2018
 */
@Controller
@RequestMapping("openapi/payment/callback")
public class PaymentCallbackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentProperties paymentProperties;

    @PostMapping("/test/alipay/notify")
    @ResponseBody
    public void notifyUrl(@RequestParam Map<String, String> paramsMap, HttpServletResponse httpResponse) throws IOException, ParseException {
        logger.debug("测试订单回调成功");
        alipayCallbackTemplate(paramsMap, httpResponse, pMap -> {
        });
    }

    private static Set<String> orders = new HashSet<>();

    @PostMapping("/test/wxpay/notify")
    @ResponseBody
    public void notifyUrl4WX(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("测试订单回调成功");
        wxpayHandlerTemplate(request, response, pMap -> {
            System.out.println(pMap.get(""));
        });
    }
    private void alipayCallbackTemplate(@RequestParam Map<String, String> paramsMap, HttpServletResponse httpResponse, AliPayOrderHandler handler) throws IOException, ParseException {
        logger.debug("准备执行支付宝回调操作");
        logger.trace("回传参数：{}", paramsMap);
        try {
            boolean signVerified = false;
            logger.debug("执行签名校验");
            signVerified = AlipaySignature.rsaCheckV1(
                    paramsMap,
                    paymentProperties.getSandbox() ? paymentProperties.getAliPay().getSandbox().getAlipayPublicKey() : paymentProperties.getAliPay().getAlipayPublicKey(),
                    Charsets.UTF_8.toString(), "RSA");
            if (signVerified) {
                logger.debug("签名校验通过");
                String orderNo = paramsMap.get("out_trade_no");     //todo::
                boolean handleFlag = checkHandle(orderNo);

//                if (handleFlag) {
//                    logger.debug("订单\"{}\"已处理", orderNo);
//                } else {
//                    logger.debug("订单\"{}\"未处理，准备处理订单", orderNo);
//                    handler.handle(paramsMap);
//                    logger.debug("处理完成");
//                }
                handler.handle(paramsMap);
                httpResponse.getWriter().println("success");
            } else {
                logger.debug("签名校验不通过");
                httpResponse.getWriter().println("failure");
            }
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void wxpayHandlerTemplate(HttpServletRequest request, HttpServletResponse response, WxPayOrderHandler handler) throws Exception {
        Map<String, String> result = new HashMap<>();
        logger.debug("---准备执行微信回调操作---");
        logger.debug("读取参数");
        Map<String, String> params = WXPayUtil.xmlToMap(IOUtils.readToString(request.getInputStream()));
        logger.trace("params: {}", params);
        logger.debug("执行签名校验");
        if (WXPayUtil.isSignatureValid(params, paymentProperties.getWxPay().getAppSecret())) {
            logger.debug("签名校验通过");
            String orderNo = params.get("out_trade_no");
            boolean handleFlag = checkHandle(orderNo);

//            if (handleFlag) {
//                logger.debug("订单\"{}\"已处理", orderNo);
//            } else {
//                logger.debug("订单\"{}\"未处理，准备处理订单", orderNo);
//                handler.handle(params);
//                logger.debug("处理完成");
//            }
            handler.handle(params);

            result.put("return_code", "SUCCESS");
            result.put("return_msg", "OK");
        } else {
            logger.error("签名校验失败");
            result.put("return_code", "FAIL");
            result.put("return_msg", "Invalid Signature");
        }
        String resultXml = WXPayUtil.mapToXml(result);
        logger.trace("response data: {}", resultXml);
        response.setContentType("text/xml");
        ServletOutputStream out = response.getOutputStream();
        out.print(resultXml);
        out.flush();
        out.close();
        logger.debug("---微信回调操作执行完成---");
    }

    private synchronized boolean checkHandle(String orderNo) {
        boolean handleFlag = false;
        //todo:: 后续应换成redis存储
        if (orders.contains(orderNo)) {
            handleFlag = true;
        } else {
            orders.add(orderNo);
        }
        return handleFlag;
    }

    @FunctionalInterface
    private interface AliPayOrderHandler {

        void handle(Map<String, String> paramsMap) throws ParseException;
    }

    @FunctionalInterface
    private interface WxPayOrderHandler {

        void handle(Map<String, String> paramsMap) throws ParseException;
    }

}
