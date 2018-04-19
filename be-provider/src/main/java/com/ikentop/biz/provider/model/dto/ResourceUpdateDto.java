package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/1
 */
public class ResourceUpdateDto {
    @ApiModelProperty(value = "资源id", required = true)
    @NotBlank(message = "资源id不能为空")
    private String id;
    @ApiModelProperty(value = "父级ID")
    private String parentId;
    @ApiModelProperty(value = "资源名称")
    private String resourceTitle;
    @ApiModelProperty(value = "资源简介")
    private String summary;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
}
