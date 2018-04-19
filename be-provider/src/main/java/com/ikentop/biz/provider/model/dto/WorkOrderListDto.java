package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/21
 */
public class WorkOrderListDto extends PaginationRequest {
    @ApiModelProperty(value = "工单类型")
    private Integer type;
    @ApiModelProperty(value = "工单状态")
    private Integer status;
    @ApiModelProperty(value = "组织id", hidden = true)
    private String orgId;
    @ApiModelProperty(value = "限制类型", hidden = true)
    private Integer typeLimit;

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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getTypeLimit() {
        return typeLimit;
    }

    public void setTypeLimit(Integer typeLimit) {
        this.typeLimit = typeLimit;
    }
}
