package com.bee;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/12/11.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1455966096222l);
        System.out.print(cal.getTime().toString());
    }
}
