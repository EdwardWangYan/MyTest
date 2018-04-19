package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Table(name = "pat_org_staff_operator_relation")
public class OperatorStaff extends GenericUUIDModel {

    private String staffId;
    private String operatorId;
    private Date effectiveTime;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

}
