package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/1
 */
public class OrgTypeUpdateDto {
    @ApiModelProperty(value = "机构类型Id", required = true)
    @NotBlank(message = "机构类型不能为空")
    private String id;
    @ApiModelProperty(value = "名称")
    private String title;
    @ApiModelProperty(value = "机构简称")
    private String shortTitle;
    @ApiModelProperty(value = "logo")
    private String orgLogoFileId;
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
