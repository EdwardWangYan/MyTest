package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public class OrganizationCreateDto extends OrganizationCommonDto {
    @ApiModelProperty(value = "机构类型code", required = true)
    @NotBlank(message = "机构类型code不能为空")
    private String orgTypeCode;
    @ApiModelProperty(value = "父机构id")
    private String parentId;
    @ApiModelProperty(value = "登录账号名", required = true)
    @NotBlank(message = "登录账号名不能为空")
    private String loginName;
    @ApiModelProperty(value = "登录密码")
    private String password;

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
