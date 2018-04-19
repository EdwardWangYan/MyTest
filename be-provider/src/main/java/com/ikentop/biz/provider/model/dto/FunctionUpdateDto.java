package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class FunctionUpdateDto extends FunctionCommonDto{

    @ApiModelProperty(value = "功能id",required = true)
    @NotBlank(message = "功能id不能为空")
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
