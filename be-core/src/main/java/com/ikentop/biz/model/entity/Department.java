package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericBizUUIDModel;

import javax.persistence.Table;

/**
 * @author Huqiao
 * @since 2017/9/4
 */
@Table(name = "pat_org_dept_info")
public class Department extends GenericBizUUIDModel {
    private String parentId;
    private String deptName;
    private String code;
    private String shortName;
    private String shortCode;
    private String deptLogo;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getDeptLogo() {
        return deptLogo;
    }

    public void setDeptLogo(String deptLogo) {
        this.deptLogo = deptLogo;
    }

    @Override
    public String toString() {
        return "Department{" +
                "parentId='" + parentId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", deptLogo='" + deptLogo + '\'' +
                '}';
    }
}
