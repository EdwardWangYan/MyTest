package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericBizUUIDModel;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
@Table(name = "pat_org_approve_info")
public class OrgApprove extends GenericBizUUIDModel {
    private String orgTitle;//机构名称，冗余字段
    private String permitNumber;
    private String legalPerson;
    private String addr;
    private String permitPicId;
    private Date effectiveTime;

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPermitPicId() {
        return permitPicId;
    }

    public void setPermitPicId(String permitPicId) {
        this.permitPicId = permitPicId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
