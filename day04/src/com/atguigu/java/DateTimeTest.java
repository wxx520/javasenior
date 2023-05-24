package com.atguigu.java;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wxxstar
 * @create 2023-02-27 23:20
 */
public class DateTimeTest {

    @Test
    public void calendarTest() {
        Calendar calendar = Calendar.getInstance();

        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));


        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("月份："+calendar.get(Calendar.MONTH));
        System.out.println("星期："+calendar.get(Calendar.DAY_OF_WEEK));


        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    public void instantTimeTest() {
        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(instant);
        long l = instant.toEpochMilli();
        System.out.println(l);
        System.out.println(new Date(l));
        System.out.println(Instant.ofEpochMilli(l));



    }
}
