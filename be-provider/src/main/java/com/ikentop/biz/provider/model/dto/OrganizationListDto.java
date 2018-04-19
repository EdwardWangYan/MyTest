package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class OrganizationListDto extends PaginationRequest{
    @ApiModelProperty(value = "机构类型")
    private String orgTypeCode;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "机构名称")
    private String title;

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
