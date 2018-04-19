package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;

/**
 * @author : Huqiao
 * @date : 2017/9/7
 */
@Table(name = "pat_org_operator_role_relation")
public class OperatorRole extends GenericUUIDModel {

    private String operatorId;//账号id
    private String roleId;//角色id


    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
