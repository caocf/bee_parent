package com.bee.commons;

/**
 * Created by suntongwei on 15/4/16.
 */
public final class SQL {


    public static final class Area {
        public static final String queryAreaById = "From Area A where A.parentId = ? order by A.sort desc";
    }


    public static final class User {
        // 根据帐号查询用户
        public static final String queryUserByAccount = "From User A where A.phone = ?";

    }

    /**
     * 商家
     */
    public static final class Shop {

        public static final String queryShopById = "From Shop A where A.sid = ?";

        // 查询商家列表
        public static final String queryShopList = "From Shop A left join fetch A.area B where 1=1";
        public static final String queryShopListSort = " order by A.sort desc";


        public static final class Price {
            public static final String queryShopPriceByShopId = "From ShopPrice A where A.shop.sid = ?";
        }

    }

}
