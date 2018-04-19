package com.ikentop.biz.provider.model.dto;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public class PermissionRow {
    private String id;
    private String permissionStr;
    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionStr() {
        return permissionStr;
    }

    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
