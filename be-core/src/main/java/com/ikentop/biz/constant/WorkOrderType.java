package com.ikentop.biz.constant;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public enum WorkOrderType {
    PASSWORD_RETRIEVE(1),    //找回密码
    ORGANIZATION_REGISTER(2),   //机构入驻
    ORGANIZATION_UPDATE(3),  //机构更新
    ORGANIZATION_APPROVE(4),     //机构认证信息审核
    EVENT_CHECK(5),//赛事审核
    EVENT_UPDATE(6),//赛事更新
    ;


    public Integer val;

    WorkOrderType(int val) {
        this.val = val;
    }
}
