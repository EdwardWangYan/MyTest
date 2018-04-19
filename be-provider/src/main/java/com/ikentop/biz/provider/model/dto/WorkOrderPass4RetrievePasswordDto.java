package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : Huqiao
 * @since : 2017/11/23
 */
public class WorkOrderPass4RetrievePasswordDto extends WorkOrderPassDto {
    @ApiModelProperty(value = "找回密码补充信息", required = true)
    @NotNull(message = "找回密码补充信息不能为空")
    @Valid
    private RetrievePasswordExtDto dto;

    public RetrievePasswordExtDto getDto() {
        return dto;
    }

    public void setDto(RetrievePasswordExtDto dto) {
        this.dto = dto;
    }
}
