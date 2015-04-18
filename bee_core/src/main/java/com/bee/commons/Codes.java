package com.bee.commons;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Codes {


    public static class User {
        // 400 登录账户不存在
        public static final int LoginAccount = 0x190;
        // 401 密码错误
        public static final int LoginPass = 0x191;
        // 402 注册失败
        public static final int Register = 0x192;
        // 403 手机号已存在
        public static final int AccountExist = 0x193;
    }

}
