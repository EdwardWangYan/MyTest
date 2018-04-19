package com.ikentop.biz.provider.model.bo;

import com.ikentop.biz.model.entity.ImageRecord;

import java.util.Date;

/**
 * @author tac
 * @since 17/01/2018
 */
public class ApplyPreviewBo {
    private String id;
    private EventPreviewBo4ApplyPreview event;
    private GroupPreviewBo4ApplyPreview group;
    private Integer passStatus;
    private Date applyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EventPreviewBo4ApplyPreview getEvent() {
        return event;
    }

    public void setEvent(EventPreviewBo4ApplyPreview event) {
        this.event = event;
    }

    public GroupPreviewBo4ApplyPreview getGroup() {
        return group;
    }

    public void setGroup(GroupPreviewBo4ApplyPreview group) {
        this.group = group;
    }

    public Integer getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Integer passStatus) {
        this.passStatus = passStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public static class EventPreviewBo4ApplyPreview {
        private String id;
        private String eventTitle;
        private Date eventBeginTime;
        private Date eventEndTime;
        private ImageRecord posterFile;
        private String area1;
        private String area2;
        private String eventAddr;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEventTitle() {
            return eventTitle;
        }

        public void setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
        }

        public Date getEventBeginTime() {
            return eventBeginTime;
        }

        public void setEventBeginTime(Date eventBeginTime) {
            this.eventBeginTime = eventBeginTime;
        }

        public Date getEventEndTime() {
            return eventEndTime;
        }

        public void setEventEndTime(Date eventEndTime) {
            this.eventEndTime = eventEndTime;
        }

        public ImageRecord getPosterFile() {
            return posterFile;
        }

        public void setPosterFile(ImageRecord posterFile) {
            this.posterFile = posterFile;
        }

        public String getArea1() {
            return area1;
        }

        public void setArea1(String area1) {
            this.area1 = area1;
        }

        public String getArea2() {
            return area2;
        }

        public void setArea2(String area2) {
            this.area2 = area2;
        }

        public String getEventAddr() {
            return eventAddr;
        }

        public void setEventAddr(String eventAddr) {
            this.eventAddr = eventAddr;
        }
    }

    public static class GroupPreviewBo4ApplyPreview {
        private String id;
        private Integer groupType;
        private String groupTitle;
        private Date payBeginTime;
        private Date payEndTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getGroupType() {
            return groupType;
        }

        public void setGroupType(Integer groupType) {
            this.groupType = groupType;
        }

        public String getGroupTitle() {
            return groupTitle;
        }

        public void setGroupTitle(String groupTitle) {
            this.groupTitle = groupTitle;
        }

        public Date getPayBeginTime() {
            return payBeginTime;
        }

        public void setPayBeginTime(Date payBeginTime) {
            this.payBeginTime = payBeginTime;
        }

        public Date getPayEndTime() {
            return payEndTime;
        }

        public void setPayEndTime(Date payEndTime) {
            this.payEndTime = payEndTime;
        }
    }
}
