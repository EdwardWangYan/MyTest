package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
public class Function4RoleInfo {
    @ApiModelProperty("权限id")
    private String id;
    @ApiModelProperty("父id")
    private String parentId;
    @ApiModelProperty("权限名称")
    private String title;
    @ApiModelProperty("权限简介")
    private String summary;
    @ApiModelProperty("权限字符串")
    private String permissionValue;
    @ApiModelProperty("权限说明")
    private String remark;
    @ApiModelProperty("权限类型")
    private String orgType;
    @ApiModelProperty("判断是否拥有该权限")
    private String flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
