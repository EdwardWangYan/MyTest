package com.ikentop.biz.constant;

/**
 * @author tac
 * @since 04/01/2018
 */
public enum PaymentMethod {
    UNKNOWN(-1),
    ALI_PAY(1),
    PAY_PAL(2),
    WX_PAY(3);

    private int val;

    public int getVal() {
        return val;
    }

    PaymentMethod(int val) {
        this.val = val;
    }

    public static PaymentMethod transfer(Integer type) {
        switch (type) {
            case 1:
                return PaymentMethod.ALI_PAY;
            case 2:
                return PaymentMethod.PAY_PAL;
            case 3:
                return PaymentMethod.WX_PAY;
            default:
                return PaymentMethod.UNKNOWN;
        }
    }
}
