package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;

/**
 * @author : Huqiao
 * @since : 2017/9/4
 */
@Table(name = "pat_system_resource")
public class Resource extends GenericUUIDModel {


    private Integer resourceType;//类型
    private String parentId;//父级ID
    private String resourceTitle;//资源名称
    private String summary;//资源简介
    private String resourceIcon;//图标
    private String resourceUrl;//资源URL
    private Long ordersIndex;//排序号
    private String resourceExt;//资源扩展信息EXT
    private String remark2;//说明
    private String orgType;

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

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
