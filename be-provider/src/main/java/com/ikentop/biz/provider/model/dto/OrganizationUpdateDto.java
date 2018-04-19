package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public class OrganizationUpdateDto extends OrganizationCommonDto {

    @ApiModelProperty(value = "机构id", required = true)
    @NotBlank(message = "机构id不能为空")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
