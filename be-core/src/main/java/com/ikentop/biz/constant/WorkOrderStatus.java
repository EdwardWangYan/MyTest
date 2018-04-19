package com.ikentop.biz.constant;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public enum WorkOrderStatus {
    UNTREATED(0),
    PASS(1),
    FAIL(2);


    public Integer val;

    WorkOrderStatus(int val) {
        this.val = val;
    }
}
