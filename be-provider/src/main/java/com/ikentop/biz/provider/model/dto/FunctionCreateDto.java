package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class FunctionCreateDto extends FunctionCommonDto {
    @ApiModelProperty(value = "新建功能的父级id")
    private String parentId;
    @ApiModelProperty(value = "权限字符串,唯一", required = true)
    @NotBlank(message = "权限字符串不能为空")
    private String permissionValue;
    @ApiModelProperty(value = "组织类型", required = true)
    @NotBlank(message = "组织类型不能为空")
    private String orgType;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
