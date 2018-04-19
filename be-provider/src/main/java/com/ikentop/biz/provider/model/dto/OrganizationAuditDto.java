package com.ikentop.biz.provider.model.dto;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public class OrganizationAuditDto {
    private String id;
    private Boolean isPass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPass() {
        return isPass;
    }

    public void setPass(Boolean pass) {
        isPass = pass;
    }
}
