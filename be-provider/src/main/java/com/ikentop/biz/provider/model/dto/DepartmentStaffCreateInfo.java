package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/8
 */
public class DepartmentStaffCreateInfo {
    @ApiModelProperty(value = "部门id", required = true)
    @NotBlank(message = "部门id不能为空")
    private String departmentId;
    @ApiModelProperty(value = "员工进入该部门时间", required = true)
    @NotNull(message = "员工进入该部门时间不能为空")
    private Date startTime;
    @ApiModelProperty(value = "员工离开该部门时间")
    private Date endTime;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
