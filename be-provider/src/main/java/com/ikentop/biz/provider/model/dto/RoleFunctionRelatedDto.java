package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class RoleFunctionRelatedDto {
    @ApiModelProperty(value = "角色id", required = true)
    @NotBlank(message = "角色id不能为空")
    private String roleId;
    @ApiModelProperty(value = "权限id列表", required = true)
    @NotNull(message = "权限id列表不能为空")
    private List<String> functionIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(List<String> functionIds) {
        this.functionIds = functionIds;
    }
}
