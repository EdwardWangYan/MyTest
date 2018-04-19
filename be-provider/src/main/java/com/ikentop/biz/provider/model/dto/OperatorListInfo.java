package com.ikentop.biz.provider.model.dto;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/11/3
 */
public class OperatorListInfo {
    private String id;
    private String loginName;
    private String portraitFileId;
    private String staffName;
    private List<String> roleName;
    private Integer status;

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

    public String getPortraitFileId() {
        return portraitFileId;
    }

    public void setPortraitFileId(String portraitFileId) {
        this.portraitFileId = portraitFileId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public List<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(List<String> roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
