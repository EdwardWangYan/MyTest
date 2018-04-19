package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/9
 */
public class OrgApproveEditDto {
    @ApiModelProperty(value = "机构id", required = true)
    @NotBlank(message = "机构id不能为空")
    private String id;
    @ApiModelProperty(value = "营业执照号", required = true)
    @NotBlank(message = "营业执照号不能为空")
    private String permitNumber;
    @ApiModelProperty(value = "经营地址", required = true)
    @NotBlank(message = "经营地址不能为空")
    private String addr;
    @ApiModelProperty(value = "营业执照图片ID", required = true)
    @NotBlank(message = "营业执照图片不能为空")
    private String permitPicId;
    @ApiModelProperty(value = "有效时间")
    private Date effectiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPermitPicId() {
        return permitPicId;
    }

    public void setPermitPicId(String permitPicId) {
        this.permitPicId = permitPicId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
