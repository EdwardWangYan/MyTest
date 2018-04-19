package com.ikentop.biz.provider.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Huqiao
 * @since 2018/1/16
 */
public class DateUtils {
    public static Date timeOfHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return calendar.getTime();
    }
}
