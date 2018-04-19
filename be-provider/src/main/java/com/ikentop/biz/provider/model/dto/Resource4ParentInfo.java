package com.ikentop.biz.provider.model.dto;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class Resource4ParentInfo {
    private String id;
    private String parentId;
    private Integer resourceType;//类型
    private String resourceTitle;//资源名称
    private String summary;//资源简介
    private String resourceIcon;//图标
    private String resourceUrl;//资源URL
    private String resourceExt;//资源扩展信息EXT
    private String remark2;//说明

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
