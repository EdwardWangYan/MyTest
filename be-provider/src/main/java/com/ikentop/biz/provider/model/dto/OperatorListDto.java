package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/9/6
 */
public class OperatorListDto extends PaginationRequest {
    @ApiModelProperty(value = "账号名称")
    private String loginName;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "组织id", hidden = true)
    private String orgId;
    @ApiModelProperty(value = "当前所属组织类型", hidden = true)
    private String currentOrgType;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getCurrentOrgType() {
        return currentOrgType;
    }

    public void setCurrentOrgType(String currentOrgType) {
        this.currentOrgType = currentOrgType;
    }
}
