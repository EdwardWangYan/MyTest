package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : tac
 * @author : huqiaoqiao
 * @since : 06/09/2017
 */
public class RoleCreateDto {
    @ApiModelProperty(value = "角色名称", required = true)
    @NotBlank(message = "角色名称不能为空")
    @Length(min = 1, max = 20, message = "角色名称长度不能超过10")
    private String roleName;
    @ApiModelProperty(value = "标识代码，在同一组织机构内唯一", required = true)
    @NotBlank(message = "标识代码不能为空")
    private String code;
    @ApiModelProperty(value = "说明")
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
