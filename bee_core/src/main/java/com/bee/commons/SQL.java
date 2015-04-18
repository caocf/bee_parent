package com.bee.commons;

/**
 * Created by suntongwei on 15/4/16.
 */
public final class SQL {


    public static final class User {
        // 根据帐号查询用户
        public static final String queryUserByAccount = "From User A where A.phone = ?";

    }

    /**
     * 商家
     */
    public static final class Shop {

        // 查询商家列表
        public static final String queryShopList = "From Shop A where A.type = ?";
        public static final String queryShopListSort = " order by A.sort desc";

    }

}
