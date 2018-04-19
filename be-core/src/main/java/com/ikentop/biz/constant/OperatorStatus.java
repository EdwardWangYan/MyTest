package com.ikentop.biz.constant;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public enum OperatorStatus {
    INACTIVE(0),
    ACTIVE(1),
    FORBIDDEN(2),
    FREEZING(3),
    ;


    public Integer val;

    OperatorStatus(int val) {
        this.val = val;
    }
}
