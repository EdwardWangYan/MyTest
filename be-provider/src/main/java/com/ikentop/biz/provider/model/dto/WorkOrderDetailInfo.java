package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/21
 */
public class WorkOrderDetailInfo {
    @ApiModelProperty(value = "工单Id")
    private String id;
    @ApiModelProperty(value = "组织id")
    private String orgId;
    @ApiModelProperty(value = "工单类型")
    private Integer type;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "扩展字段")
    private String extJson;
    @ApiModelProperty(value = "扩展参数")
    private String extParam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

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
