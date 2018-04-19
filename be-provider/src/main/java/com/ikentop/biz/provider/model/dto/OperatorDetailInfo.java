package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.model.dto.ImageRecordInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Huqiao
 * @since : 15/11/2017
 */
public class OperatorDetailInfo {
    @ApiModelProperty(value = "账号id")
    private String operatorId;
    @ApiModelProperty(value = "员工id")
    private String staffId;
    @ApiModelProperty(value = "账号")
    private String loginName;
    @ApiModelProperty(value = "账号头像")
    private ImageRecordInfo portraitFileInfo;
    @ApiModelProperty(value = "员工姓名")
    private String staffName;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "员工工号")
    private String jobNumber;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "部门名称")
    private List<String> departmentNames;
    @ApiModelProperty(value = "职位")
    private String position;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "QQ")
    private String qqNumber;
    @ApiModelProperty(value = "微信")
    private String wechat;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStaffName() {
        return staffName;
    }

    public ImageRecordInfo getPortraitFileInfo() {
        return portraitFileInfo;
    }

    public void setPortraitFileInfo(ImageRecordInfo portraitFileInfo) {
        this.portraitFileInfo = portraitFileInfo;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<String> getDepartmentNames() {
        return departmentNames;
    }

    public void setDepartmentNames(List<String> departmentNames) {
        this.departmentNames = departmentNames;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
