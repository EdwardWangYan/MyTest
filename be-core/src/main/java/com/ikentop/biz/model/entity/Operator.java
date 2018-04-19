package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericBizUUIDModel;

import javax.persistence.Table;

/**
 * @author : tac
 * @since : 2017/9/4
 */
@Table(name = "pat_org_operator")
public class Operator extends GenericBizUUIDModel {

    private String loginName;//用户名
    private String password;//密码
    private String portraitFileId;//头像
    private String salt;//盐
    private Integer status;//状态


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

    public String getPortraitFileId() {
        return portraitFileId;
    }

    public void setPortraitFileId(String portraitFileId) {
        this.portraitFileId = portraitFileId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
