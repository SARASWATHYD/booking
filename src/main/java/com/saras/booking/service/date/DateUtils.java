package com.saras.booking.service.date;

import java.time.ZonedDateTime;

/**
 * Created by saraswathy
 * on 2021-01-12 09:03
 */
public class DateUtils {

    public  static String getDefaultEndTime(String startTime){
        return ZonedDateTime.parse(startTime).plusDays(1).toString();
    }
}
