package com.ikentop.biz.provider.domain.payment.constant;

/**
 * @author tac
 * @since 09/01/2018
 */
public enum WxPayTradeType {
    NATIVE("NATIVE"),
    JSAPI("JSAPI"),
    APP("APP");

    private String val;

    public String getVal() {
        return val;
    }

    WxPayTradeType(String val) {
        this.val = val;
    }
}
