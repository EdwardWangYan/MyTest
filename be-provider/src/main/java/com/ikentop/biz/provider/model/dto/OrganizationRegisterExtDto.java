package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/23
 */
public class OrganizationRegisterExtDto {
    @ApiModelProperty(value = "机构类型", required = true)
    @NotBlank(message = "机构类型不能为空")
    private String OrgTypeCode;
    @ApiModelProperty(value = "账号", required = true)
    @NotBlank(message = "账号不能为空")
    private String loginName;
    @ApiModelProperty(value = "密码类型", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getOrgTypeCode() {
        return OrgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        OrgTypeCode = orgTypeCode;
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
