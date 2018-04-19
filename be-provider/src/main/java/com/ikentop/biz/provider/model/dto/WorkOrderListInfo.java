package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/21
 */
public class WorkOrderListInfo {
    @ApiModelProperty(value = "工单Id")
    private String id;
    @ApiModelProperty(value = "组织id")
    private String orgId;
    @ApiModelProperty(value = "组织名称")
    private String orgName;
    @ApiModelProperty(value = "工单类型")
    private Integer type;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "扩展字段")
    private String extJson;
    @ApiModelProperty(value = "创建人")
    private String createName;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
