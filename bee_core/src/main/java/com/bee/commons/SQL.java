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

        public static final String queryShopById = "From Shop A left join fetch A.area B where A.sid = ?";

        // 查询商家列表
        public static final String queryShopList = "From Shop A left join fetch A.area B where 1=1";
        public static final String queryShopListSort = " order by A.sort desc";


        public static final class Price {
            public static final String queryShopPriceByShopId = "From ShopPrice A left join fetch A.shop B where B.sid = ?";
            public static final String getShopPriceById = "From ShopPrice A left join fetch A.shop B where A.spid = ?";
        }

        public static final class Image {
            public static final String queryShopImageByShopId = "From ShopImage A left join fetch A.shop B where B.sid = ?";
            public static final String getShopImageById = "From ShopImage A left join fetch A.shop B where A.siid = ?";
        }

    }


    public static final class Order {

        public static final String getOrderListByParam = "From Order A left join fetch A.shop B left join fetch A.user C where 1=1 ";
        public static final String getOrderListByParamOrder = " order by A.status desc";
    }

}
