package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.model.dto.ImageRecordInfo;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
public class OrgApproveDetailInfo {
    private String id;
    private String orgId;
    private String orgTitle;
    private String permitNumber;
    private String legalPerson;
    private String addr;
    private ImageRecordInfo permitPicInfo;
    private String effectiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

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

    public ImageRecordInfo getPermitPicInfo() {
        return permitPicInfo;
    }

    public void setPermitPicInfo(ImageRecordInfo permitPicInfo) {
        this.permitPicInfo = permitPicInfo;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
