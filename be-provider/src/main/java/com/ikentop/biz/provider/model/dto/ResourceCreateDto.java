package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public abstract class ResourceCreateDto {
    @ApiModelProperty(value = "资源名称")
    private String resourceTitle;
    @ApiModelProperty(value = "图标")
    private String resourceIcon;
    @ApiModelProperty(value = "资源URL")
    private String resourceUrl;
    @ApiModelProperty(value = "排序号")
    private Long ordersIndex;
    @ApiModelProperty(value = "资源扩展信息EXT")
    private String resourceExt;
    @ApiModelProperty(value = "说明")
    private String remark2;
    @ApiModelProperty(value = "资源简介")
    private String summary;
    @ApiModelProperty(value = "组织类型", required = true)
    @NotBlank(message = "组织类型不能为空")
    private String orgType;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Long getOrdersIndex() {
        return ordersIndex;
    }

    public void setOrdersIndex(Long ordersIndex) {
        this.ordersIndex = ordersIndex;
    }

    public String getResourceExt() {
        return resourceExt;
    }

    public void setResourceExt(String resourceExt) {
        this.resourceExt = resourceExt;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
