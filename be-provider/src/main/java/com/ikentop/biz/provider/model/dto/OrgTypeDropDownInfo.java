package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/29
 */
public class OrgTypeDropDownInfo {
    @ApiModelProperty(value = "机构类型id")
    private String id;
    @ApiModelProperty(value = "名称")
    private String title;
    @ApiModelProperty(value = "唯一标识")
    private String code;
    @ApiModelProperty(value = "简称1")
    private String shortTitle;
    @ApiModelProperty(value = "图标")
    private String orgLogoFileId;
    @ApiModelProperty(value = "简介")
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
