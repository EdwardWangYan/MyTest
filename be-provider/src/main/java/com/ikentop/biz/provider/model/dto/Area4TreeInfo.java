package com.ikentop.biz.provider.model.dto;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
public class Area4TreeInfo {
    private String id;
    private String parentId;
    private String title;
    private Integer areaLevel;

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

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }
}
