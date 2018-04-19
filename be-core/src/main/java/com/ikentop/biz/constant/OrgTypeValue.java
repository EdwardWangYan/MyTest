package com.ikentop.biz.constant;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public enum OrgTypeValue {
    PLATFORM("platform"),
    INSTITUTION("institution"),
    COMMON("common"),
    SPECIFIC("specific"),
    TEST("15"),;

    public String val;

    OrgTypeValue(String val) {
        this.val = val;
    }
}
