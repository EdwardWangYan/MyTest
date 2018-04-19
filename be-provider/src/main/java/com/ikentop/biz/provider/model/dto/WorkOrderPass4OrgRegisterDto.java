package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : Huqiao
 * @since : 2017/11/23
 */
public class WorkOrderPass4OrgRegisterDto extends WorkOrderPassDto {
    @ApiModelProperty(value = "机构入驻补充信息", required = true)
    @NotNull(message = "机构入驻补充信息不能为空")
    @Valid
    private OrganizationRegisterExtDto dto;

    public OrganizationRegisterExtDto getDto() {
        return dto;
    }

    public void setDto(OrganizationRegisterExtDto dto) {
        this.dto = dto;
    }
}
