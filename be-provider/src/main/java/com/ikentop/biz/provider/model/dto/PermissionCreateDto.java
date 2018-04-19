package com.ikentop.biz.provider.model.dto;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public class PermissionCreateDto {
    private String name;
    private String permStr;
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermStr() {
        return permStr;
    }

    public void setPermStr(String permStr) {
        this.permStr = permStr;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
