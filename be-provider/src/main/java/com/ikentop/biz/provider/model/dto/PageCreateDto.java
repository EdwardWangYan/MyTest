package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.provider.model.interf.ChildNode;

/**
 * @author : tac
 * @since : 14/09/2017
 */
public class PageCreateDto extends ResourceCreateDto implements ChildNode {
    private String parentId;

    @Override
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
