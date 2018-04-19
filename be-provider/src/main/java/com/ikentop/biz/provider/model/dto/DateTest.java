package com.ikentop.biz.provider.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Huqiao
 * @since 2018/1/16
 */
public class DateTest {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date2;
    private Date date3;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }
}
