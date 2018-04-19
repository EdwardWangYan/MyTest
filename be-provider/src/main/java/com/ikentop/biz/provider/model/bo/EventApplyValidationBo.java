package com.ikentop.biz.provider.model.bo;

import java.util.Date;
import java.util.List;

/**
 * @author tac
 * @since 19/01/2018
 */
public class EventApplyValidationBo {
    private String eventId;
    private String groupId;
    private String realName;
    private String mobile;
    private String teamTitle;
    private String teamSlogan;
    private String teamOptionalId;
    private List<EventApplyMemberValidationBo> members;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public String getTeamSlogan() {
        return teamSlogan;
    }

    public void setTeamSlogan(String teamSlogan) {
        this.teamSlogan = teamSlogan;
    }

    public String getTeamOptionalId() {
        return teamOptionalId;
    }

    public void setTeamOptionalId(String teamOptionalId) {
        this.teamOptionalId = teamOptionalId;
    }

    public List<EventApplyMemberValidationBo> getMembers() {
        return members;
    }

    public void setMembers(List<EventApplyMemberValidationBo> members) {
        this.members = members;
    }

    public static class EventApplyMemberValidationBo {
        private String name;
        private Integer gender;
        private Date birthday;
        private Integer bloodType;
        private String mobile;
        private String email;
        private Integer idcardType;
        private String idcardNumber;
        private String policyCompany;
        private String policyNumber;
        private String address;
        private String emergencyContact;
        private String emergencyContactPhoneNumber;
        private Integer memberPosition;
        private String optionalId;
        private String groupRoleId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public Integer getBloodType() {
            return bloodType;
        }

        public void setBloodType(Integer bloodType) {
            this.bloodType = bloodType;
        }

        public String getMobile() {
            return mobile;
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

        public Integer getIdcardType() {
            return idcardType;
        }

        public void setIdcardType(Integer idcardType) {
            this.idcardType = idcardType;
        }

        public String getIdcardNumber() {
            return idcardNumber;
        }

        public void setIdcardNumber(String idcardNumber) {
            this.idcardNumber = idcardNumber;
        }

        public String getPolicyCompany() {
            return policyCompany;
        }

        public void setPolicyCompany(String policyCompany) {
            this.policyCompany = policyCompany;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmergencyContact() {
            return emergencyContact;
        }

        public void setEmergencyContact(String emergencyContact) {
            this.emergencyContact = emergencyContact;
        }

        public String getEmergencyContactPhoneNumber() {
            return emergencyContactPhoneNumber;
        }

        public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
            this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
        }

        public Integer getMemberPosition() {
            return memberPosition;
        }

        public void setMemberPosition(Integer memberPosition) {
            this.memberPosition = memberPosition;
        }

        public String getOptionalId() {
            return optionalId;
        }

        public void setOptionalId(String optionalId) {
            this.optionalId = optionalId;
        }

        public String getGroupRoleId() {
            return groupRoleId;
        }

        public void setGroupRoleId(String groupRoleId) {
            this.groupRoleId = groupRoleId;
        }
    }
}
