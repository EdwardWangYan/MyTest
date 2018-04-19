package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class FunctionDetailInfo {
    @ApiModelProperty(value = "功能id")
    private String id;
    @ApiModelProperty(value = "父级id")
    private String parentId;
    @ApiModelProperty(value = "父级名称")
    private String parentName;
    @ApiModelProperty(value = "功能名称")
    private String functionTitle;
    @ApiModelProperty(value = "功能简介")
    private String summary;
    @ApiModelProperty(value = "说明")
    private String remark;
    @ApiModelProperty(value = "权限字符串,唯一")
    private String permissionValue;
    @ApiModelProperty(value = "组织类型名称")
    private String orgTypeName;
    @ApiModelProperty(value = "组织类型code")
    private String orgType;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getFunctionTitle() {
        return functionTitle;
    }

    public void setFunctionTitle(String functionTitle) {
        this.functionTitle = functionTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
