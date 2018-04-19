package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/11/20
 */
public abstract class StaffCommonDto {
    @ApiModelProperty(value = "员工姓名", required = true)
    @NotBlank(message = "员工姓名不能为空")
    private String staffName;
    @ApiModelProperty(value = "员工工号")
    private String jobNumber;
    @ApiModelProperty(value = "员工性别")
    private Integer gender;
    @ApiModelProperty(value = "座机电话")
    private String telphone;
    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机须为11位")
    private String mobile;
    @ApiModelProperty(value = "职位")
    private String position;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "qq")
    private String qqNumber;
    @ApiModelProperty(value = "微信号")
    private String wechat;
    @ApiModelProperty(value = "员工照片")
    private String photoFileId;
    @ApiModelProperty(value = "紧急联系人姓名")
    private String emergencyPerson;
    @ApiModelProperty(value = "紧急联系人电话")
    private String emergencyPhone;
    @ApiModelProperty(value = "入职时间")
    private Date entryTime;
    @ApiModelProperty(value = "离职时间")
    private Date departureTime;
    @ApiModelProperty(value = "部门id列表", required = true)
    @NotNull(message = "部门id不能为空")
    @Valid
    private List<DepartmentStaffCreateInfo> departmentInfo;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public List<DepartmentStaffCreateInfo> getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(List<DepartmentStaffCreateInfo> departmentInfo) {
        this.departmentInfo = departmentInfo;
    }
}
