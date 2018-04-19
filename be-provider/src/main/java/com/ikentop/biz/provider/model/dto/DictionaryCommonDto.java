package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/20
 */
public abstract class DictionaryCommonDto {
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "数据字段名称不能为空")
    private String dataName;
    @ApiModelProperty(value = "值", required = true)
    @NotBlank(message = "数据字段的值不能为空")
    private String dataValue;
    @ApiModelProperty(value = "说明")
    private String remark;


    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
