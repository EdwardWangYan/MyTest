package com.ikentop.biz.model.dto;

/**
 * @author tac
 * @since 26/10/2017
 */
public class OSSDto {
    public OSSDto(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
