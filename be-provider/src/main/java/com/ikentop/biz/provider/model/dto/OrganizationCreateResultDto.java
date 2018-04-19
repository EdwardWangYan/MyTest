package com.ikentop.biz.provider.model.dto;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public class OrganizationCreateResultDto {
   private String id;
   private String loginName;
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
