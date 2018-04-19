package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @date : 2017/9/5
 */
public class MinOperatorInfo {
    @ApiModelProperty(value = "账号id")
    private String id;
    @ApiModelProperty(value = "账号名")
    private String loginName;
    @ApiModelProperty(value = "密码")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
