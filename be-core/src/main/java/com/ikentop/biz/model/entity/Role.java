package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericBizUUIDModel;

import javax.persistence.Table;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Table(name = "pat_system_role_info")
public class Role extends GenericBizUUIDModel {

    private String roleName;//角色名称
    private String code;//角色编码
    private String typeId;//角色类型
    private String remark;//备注


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
