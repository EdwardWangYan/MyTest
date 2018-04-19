package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class DepartmentUpdateDto {
    @ApiModelProperty(value = "部门id", required = true)
    @NotBlank(message = "部门id不能为空")
    private String id;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "部门简称")
    private String shortName;
    @ApiModelProperty(value = "简称字母")
    private String shortCode;
    @ApiModelProperty(value = "部门logo")
    private String deptLogo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getDeptLogo() {
        return deptLogo;
    }

    public void setDeptLogo(String deptLogo) {
        this.deptLogo = deptLogo;
    }
}
