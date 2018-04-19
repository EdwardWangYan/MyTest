package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/5
 */
public class OperatorCreateDto {
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 30, message = "用户名长度应在6-30之间")
    private String loginName;

    @ApiModelProperty(value = "员工ID", required = true)
    @NotBlank(message = "员工不能为空")
    private String staffId;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
