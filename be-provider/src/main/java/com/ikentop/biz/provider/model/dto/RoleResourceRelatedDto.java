package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/11/22
 */
public class RoleResourceRelatedDto {
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "资源id列表")
    private List<String> resouceIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getResouceIds() {
        return resouceIds;
    }

    public void setResouceIds(List<String> resouceIds) {
        this.resouceIds = resouceIds;
    }
}
