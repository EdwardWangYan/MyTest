package com.ikentop.biz.constant;

/**
 * @author : tac
 * @since : 12/09/2017
 */
public enum DeletedFlag {
    DISABLED(1),
    ENABLE(0),;

    private int val;

    public int getVal() {
        return val;
    }

    DeletedFlag(int val) {
        this.val = val;
    }
}
