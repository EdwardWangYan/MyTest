package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : tac
 * @since : 14/09/2017
 */
public class ResourceListInfo {
    @ApiModelProperty(value = "资源id")
    private String id;
    @ApiModelProperty(value = "父id")
    private String parentId;
    @ApiModelProperty(value = "资源类型")
    private Integer resourceType;
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
    @ApiModelProperty(value = "父名称")
    private String parentName;
    @ApiModelProperty(value = "所属类型")
    private String orgType;
    @ApiModelProperty(value = "所属类型名称")
    private String orgTypeName;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }
}
