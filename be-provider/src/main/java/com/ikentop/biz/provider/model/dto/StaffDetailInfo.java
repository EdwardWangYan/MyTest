package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class StaffDetailInfo {
    @ApiModelProperty(value = "员工id")
    private String id;
    @ApiModelProperty(value = "员工姓名")
    private String staffName;
    @ApiModelProperty(value = "员工工号")
    private String jobNumber;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "电话")
    private String telphone;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "职位")
    private String position;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "QQ")
    private String qqNumber;
    @ApiModelProperty(value = "微信")
    private String wechat;
    @ApiModelProperty(value = "照片")
    private String photoFileId;
    @ApiModelProperty(value = "紧急联系人")
    private String emergencyPerson;
    @ApiModelProperty(value = "紧急联系人电话")
    private String emergencyPhone;
    @ApiModelProperty(value = "入职时间")
    private Date entryTime;
    @ApiModelProperty(value = "离职时间")
    private Date departureTime;
    @ApiModelProperty(value = "部门信息列表")
    private List<DepartmentStaffInfo> departmentInfo;
    @ApiModelProperty(value = "账号")
    private String operatorName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getPhotoFileId() {
        return photoFileId;
    }

    public void setPhotoFileId(String photoFileId) {
        this.photoFileId = photoFileId;
    }

    public String getEmergencyPerson() {
        return emergencyPerson;
    }

    public void setEmergencyPerson(String emergencyPerson) {
        this.emergencyPerson = emergencyPerson;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public List<DepartmentStaffInfo> getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(List<DepartmentStaffInfo> departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
