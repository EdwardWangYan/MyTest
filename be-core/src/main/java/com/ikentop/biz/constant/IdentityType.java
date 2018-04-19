package com.ikentop.biz.constant;

/**
 * @author tac
 * @since 28/12/2017
 */
public enum IdentityType {
    PHONE(1),
    MAIL(2),
    ACCOUNT(3),
    QQ(4),
    WECHAT(5),
    SINA(6),
    ALIPAY(7);

    private int val;

    public int getVal() {
        return val;
    }

    IdentityType(int val) {
        this.val = val;
    }
}
