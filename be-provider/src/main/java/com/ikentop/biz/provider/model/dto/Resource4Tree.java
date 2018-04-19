package com.ikentop.biz.provider.model.dto;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class Resource4Tree {
    private String id;
    private String parentId;
    private String title;
    private Integer resourceType;
    private String summary;
    private String icon;
    private String resourceUrl;
    private Long ordersIndex;
    private String resourceExt;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
