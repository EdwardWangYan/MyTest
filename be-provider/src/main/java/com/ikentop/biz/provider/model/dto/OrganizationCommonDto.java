package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/21
 */
public abstract class OrganizationCommonDto {
    @ApiModelProperty(value = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String title;
    @ApiModelProperty(value = "机构全称", required = true)
    @NotBlank(message = "机构全称不能为空")
    private String fullName;
    @ApiModelProperty(value = "机构简称")
    private String shortName;
    @ApiModelProperty(value = "机构简称代码")
    private String shortCode;
    @ApiModelProperty(value = "图片、文件资源")
    private String orgLogoId;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "联系人不能为空")
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    private String telephone;
    @ApiModelProperty(value = "机构法人代表", required = true)
    @NotBlank(message = "机构法人不能为空")
    private String contactPerson;
    @ApiModelProperty(value = "简介")
    private String summary;
    @ApiModelProperty(value = "说明")
    private String remark;

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
}
