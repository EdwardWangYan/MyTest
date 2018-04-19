package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.model.dto.ImageRecordInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
public class OrganizationDetailInfo {
    @ApiModelProperty(value = "组织id")
    private String id;
    @ApiModelProperty(value = "组织名称")
    private String title;
    @ApiModelProperty(value = "组织code")
    private String code;
    @ApiModelProperty(value = "组织类型名称")
    private String orgTypeName;
    @ApiModelProperty(value = "组织类型code")
    private String orgTypeCode;
    @ApiModelProperty(value = "全称")
    private String fullName;
    @ApiModelProperty(value = "简称")
    private String shortName;
    @ApiModelProperty(value = "简称字母")
    private String shortCode;
    @ApiModelProperty(value = "简称父id")
    private String parentId;
    @ApiModelProperty(value = "图标logo")
    private ImageRecordInfo orgLogoInfo;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "法人")
    private String contactPerson;
    @ApiModelProperty(value = "说明")
    private String summary;
    @ApiModelProperty(value = "简介")
    private String remark;
    @ApiModelProperty(value = "状态")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
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

    public ImageRecordInfo getOrgLogoInfo() {
        return orgLogoInfo;
    }

    public void setOrgLogoInfo(ImageRecordInfo orgLogoInfo) {
        this.orgLogoInfo = orgLogoInfo;
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
