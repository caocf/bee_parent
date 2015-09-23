package com.bee.commons;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Codes {

    // 200
    public static final int Success = 0xc8;
    // 100
    public static final int Error = 0x64;

    public static final int ParamsError = 0x64;

    public static final class User {
        // 400 登录账户不存在
        public static final int LoginAccount = 0x190;
        // 401 密码错误
        public static final int LoginPass = 0x191;
        // 402 注册失败
        public static final int Register = 0x192;
        // 403 手机号已存在
        public static final int AccountExist = 0x193;
    }


    public static final class Order {
        // 300 创建订单失败
        public static final int CreateError = 0x12c;
        // 301 取消订单失败
        public static final int CancelError = 0x12d;
        // 订单无法取消
        public static final String CancelErrorStr = "不能取消订单";
    }

}
