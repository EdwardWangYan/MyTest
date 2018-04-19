package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
public class DepartmentCreateDto {
    @ApiModelProperty(value = "上一级部门ID")
    private String parentId;
    @ApiModelProperty(value = "部门名称", required = true)
    @NotBlank(message = "部门名称不能为空")
    private String deptName;
    @ApiModelProperty(value = "部门code,具有唯一性", required = true)
    @NotBlank(message = "部门code不能为空")
    private String code;
    @ApiModelProperty(value = "部门的简称")
    private String shortName;
    @ApiModelProperty(value = "简称字母")
    private String shortCode;
    @ApiModelProperty(value = "部门logo")
    private String deptLogo;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
