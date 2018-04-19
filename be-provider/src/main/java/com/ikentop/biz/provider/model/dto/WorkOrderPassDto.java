package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/17
 */
public class WorkOrderPassDto {
    @ApiModelProperty(value = "工单id", required = true)
    @NotBlank(message = "工单id不能为空")
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
