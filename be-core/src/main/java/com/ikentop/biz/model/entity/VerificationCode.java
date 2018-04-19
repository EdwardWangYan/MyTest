package com.ikentop.biz.model.entity;

import com.ikentop.biz.util.CommonUtils;
import com.ikentop.framework.core.pojo.GenericUUIDModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author Huqiao
 * @since 2018/1/5
 */
@Table(name = "pat_verification_code")
public class VerificationCode extends GenericUUIDModel {
    @Override
    public void init() {
        setPk(newPk());
        setCreatedBy(CommonUtils.nullUUID());
        setCreatedOn(new Date());
        setUpdatedBy(null);
        setUpdatedOn(null);
        setDeletedFlag(0);
    }

    @ApiModelProperty("接收方")
    private String receiver;
    @ApiModelProperty("验证码")
    private String verificationCode;
    @ApiModelProperty("过期时间")
    private Date expirationTime;
    @ApiModelProperty("状态")
    private Integer status;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
