package com.bee.commons;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Consts {

    public static final int True = 0x1;
    public static final int False = 0x0;

    public static class User {

        public static final class Type {
            public static final int AdminUser = 0x0;
            public static final int AppUser = 0x1;
            public static final int BussUser = 0x2;
        }


    }

    public static final class Shop {

        public static final class Type {
            // 会所
            public static final int Club = 0;
            // 足浴
            public static final int Massage = 1;
            // KTV
            public static final int Ktv = 2;
            // 酒吧
            public static final int Bar = 3;
        }

        public static final class ErrorStatus {
            // 普通状态
            public static final int New = 1;
            // 进行中
            public static final int Doing = 2;
            // 结束状态
            public static final int End = 3;
        }
    }


}
