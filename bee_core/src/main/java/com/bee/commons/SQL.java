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
        // 根据参数查询用户列表
        public static final String queryUserListByParams = "From User A where 1=1";
        public static final String queryUserListByParamsSort = " order by A.uid desc";

        public static final class Friend {
            // 获取该用户的所有好友
            public static final String getFriendByUser = "From UserFriend A where A.user.uid = ? or A.friend.uid = ?";
        }
    }

    /**
     * 商家
     */
    public static final class Shop {

        public static final String queryShopById = "From Shop A left join fetch A.area B where A.sid = ?";

        public static final String getShopItemById =
                "select A.sid, A.name, A.price, A.linkname, A.phone, A.addr, A.remark, A.lon, A.lat, B.name as area, A.type, " +
                        "(select C.url from TB_SHOP_IMAGE C where C.shop = A.sid and C.type = " + Consts.Shop.ImageType.Big + " order by C.sort desc limit 1) as image " +
                        "from TB_SHOP A left outer join TB_AREA B on A.area = B.aid where A.sid = ?";

        // 查询商家列表
        public static final String queryShopList = "From Shop A left join fetch A.area B where 1=1";
        public static final String queryShopListSort = " order by A.sort desc";

        // 查询好友关注数
        public static final String queryAppShopList =
                "select " +
                "A.sid,A.name,A.addr,A.price,B.name as area," +
                "(select C.url from TB_SHOP_IMAGE C where C.shop = A.sid and C.type = " + Consts.Shop.ImageType.Big + " order by C.sort desc limit 1) as image, " +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "(select count(*) from TB_USER_FRIEND E left outer join TB_SHOP_FOCUS F on E.FRIEND = F.USER where F.shop = A.sid and E.user = ?) as friendNum " +
                "from TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid " +
                "where A.status = " + Consts.Shop.Status.Run;
        public static final String queryAppShopListSort = " order by A.sort desc";

        public static final class Price {
            public static final String queryShopPriceByShopId = "From ShopPrice A left join fetch A.shop B where B.sid = ?";
            public static final String getShopPriceById = "From ShopPrice A left join fetch A.shop B where A.spid = ?";
        }

        public static final class Image {
            public static final String queryShopImageByShopId = "From ShopImage A left join fetch A.shop B where B.sid = ?";
            public static final String getShopImageById = "From ShopImage A left join fetch A.shop B where A.siid = ?";
        }

        public static final class Focus {
            public static final String getFocusList = "From ShopFocus A where A.shop.sid = ?";

            public static final String getShopFocusFriend = "select B.`NAME`, B.UID, B.IMAGE " +
                    "from TB_USER_FRIEND A left outer join TB_USER B on A.friend = B.uid " +
                    "left outer join TB_SHOP_FOCUS C on A.friend=C.`USER`" +
                    "where A.`USER` = ? and C.shop = ?";
        }
    }


    public static final class Order {

        public static final String getOrderListByParam = "From Order A left join fetch A.shop B left join fetch A.user C where 1=1 ";
        public static final String getOrderListByParamOrder = " order by A.status asc, A.createTime desc";
    }


    public static final class AppVer {

        public static final String getAppVerList = "From AppVer A order by A.createTime desc";
    }


    public static final class Market {

        public static final class Ad {

            public static final String getAdList = "From Ad A left join fetch A.shop B order by A.stopTime asc";
        }
    }
}
