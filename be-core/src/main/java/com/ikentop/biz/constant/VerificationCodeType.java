package com.ikentop.biz.constant;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public enum VerificationCodeType {
    NUMBER(1), //纯数字
    NUM_LOWER_CASE(2), //数字和小写字母
    NUM_CASE(3); //数字和大小写字母


    public Integer val;

    VerificationCodeType(int val) {
        this.val = val;
    }
}
