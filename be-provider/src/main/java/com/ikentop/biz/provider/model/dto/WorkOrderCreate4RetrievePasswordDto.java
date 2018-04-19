package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/17
 */
public class WorkOrderCreate4RetrievePasswordDto extends WorkOrderCreateDto {
    @ApiModelProperty(value = "扩展字段", required = true)
    protected RetrievePasswordDto extJson;

    public RetrievePasswordDto getExtJson() {
        return extJson;
    }

    public void setExtJson(RetrievePasswordDto extJson) {
        this.extJson = extJson;
    }
}
