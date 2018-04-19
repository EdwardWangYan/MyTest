package com.ikentop.biz.model.entity;

import com.ikentop.biz.constant.OrganizationStatus;
import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Table(name = "pat_org_info")
public class Organization extends GenericUUIDModel {

    @Override
    public void init() {
        super.init();
        if (this.status == null)
            this.status = OrganizationStatus.CKECK_PENDING.getVal();
    }

    private String title;//机构名称
    private String code;
    private String orgTypeCode;//机构类型ID，关联机构类型表code
    private String fullName;//机构全称
    private String shortName;//机构简称
    private String shortCode;//机构简称代码
    private String parentId;//父机构id
    private String orgLogoId;//图片、文件资源与文件表中ID关联
    private String website;//网址
    private String email;//邮箱
    private String telephone;//电话
    private String contactPerson;//联系人
    private String summary;
    private String remark;
    private Integer status;

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

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgLogoId() {
        return orgLogoId;
    }

    public void setOrgLogoId(String orgLogoId) {
        this.orgLogoId = orgLogoId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
