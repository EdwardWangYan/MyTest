package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericBizUUIDModel;

import javax.persistence.Table;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
@Table(name = "comm_work_order")
public class WorkOrder extends GenericBizUUIDModel {

    private Integer type;
    private Integer status;
    private String extJson;
    private String extParam;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getExtParam() {
        return extParam;
    }

    public void setExtParam(String extParam) {
        this.extParam = extParam;
    }
}
