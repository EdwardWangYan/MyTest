package com.ikentop.biz.constant;

/**
 * @author tac
 * @since 15/11/2017
 */
public enum OSSType {
    QINIU("qiniu");

    private String code;

    public String getCode() {
        return code;
    }

    OSSType(String code) {
        this.code = code;
    }
}
