package com.saras.booking.service.date;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by saraswathy
 * on 2021-01-12 09:08
 */
public class DateUtilsTest {

    @Test
    public void getEndTime_validData(){
       String endTime = DateUtils.getDefaultEndTime("2021-02-28T18:30:00Z");
       Assert.that(endTime.equals("2021-03-01T18:30Z"),"passed");
    }
}
