package com.ikentop.biz.provider.model.bo;

/**
 * @author : tac
 * @since : 12/09/2017
 */
public class UserInfo4Session {
    private String id;
    private String username;
    private Integer status;
    private OrganizationInfo4Session org;
    private DepartmentInfo4Session department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OrganizationInfo4Session getOrg() {
        return org;
    }

    public void setOrg(OrganizationInfo4Session org) {
        this.org = org;
    }

    public DepartmentInfo4Session getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentInfo4Session department) {
        this.department = department;
    }
}
