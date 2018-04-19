package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @since 2018/1/9
 */
public class OperatorLoginExtDto extends OperatorLoginDto {
    @ApiModelProperty(value = "图片验证码", required = true)
    //@NotBlank(message = "验证码不能为空")
    private String imageCode;

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
