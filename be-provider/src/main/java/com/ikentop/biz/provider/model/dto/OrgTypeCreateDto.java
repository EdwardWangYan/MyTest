package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
public class OrgTypeCreateDto {
    @ApiModelProperty(value = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String title;
    @ApiModelProperty(value = "code,标识类型唯一性", required = true)
    @NotBlank(message = "code不能为空")
    private String code;
    @ApiModelProperty(value = "机构简称")
    private String shortTitle;
    @ApiModelProperty(value = "机构logo")
    private String orgLogoFileId;
    @ApiModelProperty(value = "说明")
    private String remark;

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
