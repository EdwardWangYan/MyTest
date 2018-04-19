package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/10/31
 */
@Table(name = "pat_org_dept_staff_relation")
public class DepartmentStaff extends GenericUUIDModel {
    private String deptId;
    private String staffId;
    private Date startTime;
    private Date endTime;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
