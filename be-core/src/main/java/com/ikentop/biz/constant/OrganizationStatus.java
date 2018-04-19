package com.ikentop.biz.constant;

/**
 * @author : tac
 * @author Huqiao
 * @since : 18/09/2017
 */
public enum OrganizationStatus {
    CKECK_PENDING(0),//待审核
    CKECK_PASSED(1),//审核通过
    CKECK_FAILED(2),//审核失败
    ;


    private Integer val;

    public Integer getVal() {
        return val;
    }

    OrganizationStatus(int val) {
        this.val = val;
    }
}
