package com.ikentop.biz.constant;

/**
 * @author tac
 * @since 11/01/2018
 */
public enum PaymentStatus {
    PAY_UNPAID(1),
    PAY_UNCONFIRMED(2),
    PAY_PASSED(3),
    PAY_FAILED(4),
    PAY_REFUNDED(5);

    private Integer val;

    public Integer getVal() {
        return val;
    }

    PaymentStatus(Integer val) {
        this.val = val;
    }
}
