package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
public class FunctionMenuInfo {
    @ApiModelProperty(value = "权限id")
    private String id;
    @ApiModelProperty(value = "权限父id")
    private String parentId;
    @ApiModelProperty(value = "权限名称")
    private String title;
    @ApiModelProperty(value = "权限简介")
    private String summary;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
