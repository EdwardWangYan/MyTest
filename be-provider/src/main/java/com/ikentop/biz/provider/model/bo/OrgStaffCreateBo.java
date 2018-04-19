package com.ikentop.biz.provider.model.bo;

/**
 * @author tac
 * @since 18/09/2017
 */
public class OrgStaffCreateBo {
    private String realName;
    private String phone;
    private Integer gender;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer etGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
