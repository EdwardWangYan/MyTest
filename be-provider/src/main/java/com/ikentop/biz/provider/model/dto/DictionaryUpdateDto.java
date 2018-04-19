package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/15
 */
public class DictionaryUpdateDto extends DictionaryCommonDto {
    @ApiModelProperty(value = "字典id", required = true)
    @NotBlank(message = "字典id不能为空")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
