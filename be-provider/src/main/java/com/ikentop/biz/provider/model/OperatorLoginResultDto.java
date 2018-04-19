package com.ikentop.biz.provider.model;

/**
 * @author : tac
 * @since : 07/09/2017
 */
public class OperatorLoginResultDto {
    private String operatorId;
    private Boolean isActive;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public static OperatorLoginResultDto waitActive(String pk) {
        OperatorLoginResultDto o = new OperatorLoginResultDto();
        o.setOperatorId(pk);
        o.setActive(true);
        return o;
    }
}
