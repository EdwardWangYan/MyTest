package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class RoleListDto extends PaginationRequest{
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "所属组织id")
    private String orgId;
    @ApiModelProperty(value = "角色描述")
    private String remark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
