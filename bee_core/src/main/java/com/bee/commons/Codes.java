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


    public static final class Shop {
        // 500
        public static final int ShopImageSizeOut = 0x1f4;
        // 501 已关注
        public static final int ShopFocusError = 0x1f5;
    }


    public static final class Order {
        // 300 创建订单失败
        public static final int CreateError = 0x12c;
        // 301 取消订单失败
        public static final int CancelError = 0x12d;
        // 302 接受订单失败
        public static final int AcceptError = 0x12e;
        // 303 拒绝订单失败
        public static final int RejectError = 0x12f;
        // 304 完成订单失败
        public static final int FinishError = 0x130;
        // 305 修改订单失败
        public static final int EditError = 0x131;
        // 306 修改订单人数未改变
        public static final int EditNoChangeError = 0x132;
        // 350 订单数据操作失败
        public static final int OrderDbError = 0x15e;
        // 订单无法取消
        public static final String CancelErrorStr = "不能取消订单";
    }


    public static final class Store {

        // 600 库存不足
        public static final int StockError = 0x258;
        // 601 没有足够的积分
        public static final int IntegralNotEnough = 0x259;
    }

}
