package com.ikentop.biz.provider.model.bo;

/**
 * @author tac
 * @since 29/12/2017
 */
public class RoleOptionalBo {
    private String roleId;
    private String roleName;
    private Integer projectType;
    private Integer optionalType;
    private String optionalTitle;
    private String optionalSummary;
    private String optionalId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getOptionalType() {
        return optionalType;
    }

    public void setOptionalType(Integer optionalType) {
        this.optionalType = optionalType;
    }

    public String getOptionalTitle() {
        return optionalTitle;
    }

    public void setOptionalTitle(String optionalTitle) {
        this.optionalTitle = optionalTitle;
    }

    public String getOptionalSummary() {
        return optionalSummary;
    }

    public void setOptionalSummary(String optionalSummary) {
        this.optionalSummary = optionalSummary;
    }

    public String getOptionalId() {
        return optionalId;
    }

    public void setOptionalId(String optionalId) {
        this.optionalId = optionalId;
    }
}
