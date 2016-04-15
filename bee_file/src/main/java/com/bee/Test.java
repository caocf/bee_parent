package com.bee;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by suntongwei on 15/12/26.
 */
public class Test {

    public static void main(String... args) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1454515200000l);
//        cal.set(Calendar.YEAR, 2016);
//        cal.set(Calendar.MONTH, 0);
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);

        System.out.println("Calendar: " + cal.getTimeInMillis());

        System.out.println(DateFormat.getInstance().format(new Date(1460687871771l)));

        System.out.println(System.currentTimeMillis());
    }
}
