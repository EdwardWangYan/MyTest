package com.ikentop.biz.provider.model.bo;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public class ListByPageBo {
    private String orgId;
    private Boolean isEnabled;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
