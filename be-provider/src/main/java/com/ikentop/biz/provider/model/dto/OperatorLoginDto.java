package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : tac
 * @since : 06/09/2017
 */
public class OperatorLoginDto {
    @ApiModelProperty(value = "用户名", required = true, example = "admin01")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;
    //todo:: 自动登录功能待实现
    @ApiModelProperty(value = "过期时间", hidden = true)
    private Integer expiredTime;
    @ApiModelProperty(value = "记住我", required = true)
    private Boolean rememberMe=false;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
