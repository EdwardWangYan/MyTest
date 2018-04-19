package com.ikentop.biz.provider.model.bo;

/**
 * @author tac
 * @since 11/01/2018
 */
public class EventApplyPaymentCreationBo {
    private String applyId;
    private String userId;

    public EventApplyPaymentCreationBo() {
    }

    public EventApplyPaymentCreationBo(String applyId, String userId) {
        this.applyId = applyId;
        this.userId = userId;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
