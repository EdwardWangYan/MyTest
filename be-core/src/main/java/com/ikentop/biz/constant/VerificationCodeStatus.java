package com.ikentop.biz.constant;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public enum VerificationCodeStatus {
    UNUSED(1),    //未使用
    USED(2), //已使用
    ;


    public Integer val;

    VerificationCodeStatus(int val) {
        this.val = val;
    }
}
