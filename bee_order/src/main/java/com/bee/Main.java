package com.bee;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/12/11.
 */
public class Main {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 5);
        cal.set(Calendar.MINUTE, 0);
        System.out.print(cal.getTimeInMillis());
    }
}
