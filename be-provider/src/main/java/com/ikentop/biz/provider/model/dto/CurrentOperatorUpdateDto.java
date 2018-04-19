package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : Huqiao
 * @since : 2017/11/15
 */
public class CurrentOperatorUpdateDto {

    @ApiModelProperty(value = "员工id", hidden = true)
    private String id;
    @ApiModelProperty(value = "头像")
    private String portraitFileId;
    @ApiModelProperty(value = "员工姓名", required = true)
    @NotBlank(message = "员工姓名不能为空")
    private String staffName;
    @ApiModelProperty(value = "员工性别")
    private Integer gender;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPortraitFileId() {
        return portraitFileId;
    }

    public void setPortraitFileId(String portraitFileId) {
        this.portraitFileId = portraitFileId;
    }

    public String getStaffName() {
        return staffName;
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
}
