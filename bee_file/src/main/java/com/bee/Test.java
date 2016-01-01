package com.bee;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/12/26.
 */
public class Test {

    public static void main(String... args) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        System.out.println("Calendar: " + cal.getTimeInMillis());

        System.out.println(System.currentTimeMillis());
    }
}
