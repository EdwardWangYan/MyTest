package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
public class DictionaryCreateDto extends DictionaryCommonDto {
    @ApiModelProperty(value = "父类id")
    private String parentId;
    @ApiModelProperty(value = "code,唯一性,通常用数据字典的英文", required = true, example = "gender")
    @NotBlank(message = "code不能为空")
    private String code;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
