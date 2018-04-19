package com.ikentop.biz.constant;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public enum CommonStatus {
    UNACTIVE(0),
    ACTIVE(1),;


    public Integer val;

    CommonStatus(int val) {
        this.val = val;
    }
}
