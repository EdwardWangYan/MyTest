package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/20
 */
public abstract class FunctionCommonDto {
    @ApiModelProperty(value = "功能名称")
    private String functionTitle;
    @ApiModelProperty(value = "功能简介")
    private String summary;
    @ApiModelProperty(value = "说明")
    private String remark;

    public String getFunctionTitle() {
        return functionTitle;
    }

    public void setFunctionTitle(String functionTitle) {
        this.functionTitle = functionTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
