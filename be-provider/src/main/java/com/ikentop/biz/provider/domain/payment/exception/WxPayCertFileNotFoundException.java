package com.ikentop.biz.provider.domain.payment.exception;

/**
 * @author tac
 * @since 26/01/2018
 */
public class WxPayCertFileNotFoundException extends RuntimeException {
    public WxPayCertFileNotFoundException(Throwable cause) {
        super("未找到微信支付证书文件，请确保您指定的文件路径正确", cause);
    }
}
