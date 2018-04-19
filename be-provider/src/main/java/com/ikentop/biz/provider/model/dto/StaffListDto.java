package com.ikentop.biz.provider.model.dto;

import com.ikentop.framework.core.pojo.PaginationRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class StaffListDto extends PaginationRequest {
    @ApiModelProperty(value = "部门id")
    private String departmentId;
    @ApiModelProperty(value = "账号名称")
    private String operatorName;
    @ApiModelProperty(value = "员工名称")
    private String staffName;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "组织id", hidden = true)
    private String orgId;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}

