package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class StaffUpdateDto extends StaffCommonDto {
    @ApiModelProperty(value = "员工id", required = true)
    @NotBlank(message = "员工id不能为空")
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
