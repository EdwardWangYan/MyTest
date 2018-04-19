package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
@Table(name = "pat_org_type")
public class OrgType extends GenericUUIDModel {


    private String title;//名称
    private String code;
    private String shortTitle;//机构简称
    private String orgLogoFileId;//logo
    private String remark;//说明

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getOrgLogoFileId() {
        return orgLogoFileId;
    }

    public void setOrgLogoFileId(String orgLogoFileId) {
        this.orgLogoFileId = orgLogoFileId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
