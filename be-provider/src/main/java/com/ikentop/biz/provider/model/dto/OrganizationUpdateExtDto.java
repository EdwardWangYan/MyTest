package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.model.dto.ImageRecordInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/27
 */
public class OrganizationUpdateExtDto {
    @ApiModelProperty(value = "机构id")
    private String id;
    @ApiModelProperty(value = "机构名称")
    private String title;
    @ApiModelProperty(value = "机构全称")
    private String fullName;
    @ApiModelProperty(value = "机构简称")
    private String shortName;
    @ApiModelProperty(value = "机构简称代码")
    private String shortCode;
    @ApiModelProperty(value = "图片、文件资源")
    private ImageRecordInfo orgLogoInfo;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "手机号")
    private String telephone;
    @ApiModelProperty(value = "机构法人代表")
    private String contactPerson;
    @ApiModelProperty(value = "简介")
    private String summary;
    @ApiModelProperty(value = "说明")
    private String remark;

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
}
