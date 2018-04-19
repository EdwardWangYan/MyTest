package com.ikentop.biz.provider.domain.payment.exception;

/**
 * @author tac
 * @since 08/01/2018
 */
public class WxPaymentException extends RuntimeException {
    public WxPaymentException(String code, String msg) {
        super(String.format("微信支付接口请求异常(%s)，异常信息：%s", code, msg));
    }
}
