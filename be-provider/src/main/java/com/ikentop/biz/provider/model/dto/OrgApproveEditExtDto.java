package com.ikentop.biz.provider.model.dto;

import com.ikentop.biz.model.dto.ImageRecordInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/28
 */
public class OrgApproveEditExtDto {
    @ApiModelProperty(value = "机构id")
    private String id;
    @ApiModelProperty(value = "营业执照号")
    private String permitNumber;
    @ApiModelProperty(value = "经营地址")
    private String addr;
    @ApiModelProperty(value = "营业执照图片ID")
    private ImageRecordInfo permitPicInfo;
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

    public ImageRecordInfo getPermitPicInfo() {
        return permitPicInfo;
    }

    public void setPermitPicInfo(ImageRecordInfo permitPicInfo) {
        this.permitPicInfo = permitPicInfo;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
