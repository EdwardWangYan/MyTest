package com.ikentop.biz.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author : Huqiao
 * @since : 2017/11/9
 */
public class OrgApproveCreateDto {
    @ApiModelProperty(value = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String orgTitle;
    @ApiModelProperty(value = "营业执照号", required = true)
    @NotBlank(message = "营业执照号不能为空")
    private String permitNumber;
    @ApiModelProperty(value = "机构法人", required = true)
    @NotBlank(message = "机构法人不能为空")
    private String legalPerson;
    @ApiModelProperty(value = "经营地址", required = true)
    @NotBlank(message = "经营地址不能为空")
    private String addr;
    @ApiModelProperty(value = "营业执照图片ID", required = true)
    @NotBlank(message = "营业执照图片ID不能为空")
    private String permitPicId;
    @ApiModelProperty(value = "有效时间")
    private Date effectiveTime;
    @ApiModelProperty(value = "机构ID", required = true)
    @NotBlank(message = "机构ID不能为空")
    private String orgId;

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
