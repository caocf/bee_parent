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
        public static final String getUsersByIdentity = "From User A where A.uid in";
        // 根据参数查询用户列表
        public static final String queryUserListByParams = "From User A where 1=1";
        public static final String queryUserListByParamsSort = " order by A.uid desc";

        public static final class Friend {
            // 获取该用户的所有好友
            public static final String getFriendByUser = "From UserFriend A where A.user.uid = ? or A.friend.uid = ?";
            // 根据ID，获取好友记录信息
            public static final String getUserFriend = "From UserFriend A where A.user.uid = ? and A.friend.uid = ?";
            // 根据ID，删除好友关系
            public static final String deleteFriend =
                    "DELETE FROM TB_USER_FRIEND WHERE (USER = ? AND FRIEND = ?) or (USER = ? AND FRIEND = ?)";
        }
    }

    /**
     * 商家
     */
    public static final class Shop {

        public static final String queryShopById = "From Shop A left join fetch A.area B " +
                "left join fetch A.image B left join fetch A.recommedImage C where A.sid = ?";

        // 查询商家列表
        public static final String queryShopList = "From Shop A left join fetch A.area B where 1=1";
        public static final String queryShopListSort = " order by A.sort desc";

        // 查询推荐商家
        public static final String queryRecommendShop =
                "select " +
                "A.sid,A.name,A.addr,A.price,B.name as area, C.URL" +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "(select count(*) from TB_USER_FRIEND E left outer join TB_SHOP_FOCUS F on E.FRIEND = F.USER where F.shop = A.sid and E.user = ?) as friendNum, " +
                "A.lon, A.lat, A.phone, A.type, A.linkName " +
                "from TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid  " +
                "LEFT OUTER JOIN TB_IMAGE C " +
                "ON A.RECOMMEDIMAGE = C.IID " +
                "where A.recommend = " + Consts.True + " and A.status = " + Consts.Shop.Status.Run + " order by A.sort desc limit 6";

        // 查询好友关注数
        public static final String queryAppShopList =
                "select " +
                "A.sid,A.name,A.addr,A.price,B.name as area, C.URL, " +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "(select count(*) from TB_USER_FRIEND E left outer join TB_SHOP_FOCUS F on E.FRIEND = F.USER where F.shop = A.sid and E.user = ?) as friendNum, " +
                "A.lon, A.lat, A.phone, A.type, A.linkName " +
                "from TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid  " +
                "LEFT OUTER JOIN TB_IMAGE C " +
                "ON A.IMAGE = C.IID " +
                "where A.status = " + Consts.Shop.Status.Run;
        public static final String queryAppShopListSort = " order by A.sort desc";

        public static final class Price {
            public static final String queryShopPriceByShopId = "From ShopPrice A left join fetch A.shop B where B.sid = ?";
            public static final String getShopPriceById = "From ShopPrice A left join fetch A.shop B where A.spid = ?";
        }

        public static final class Image {
            public static final String queryAppShopImage =
                    "select A.URL,A.REMARK from TB_SHOP_IMAGE A where A.SHOP = ? and A.TYPE = ? order by A.SORT desc";
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

        public static final class Comment {
            public static final String getAppCommentList = "SELECT " +
                    "A.SCID, A.CONTENT, A.CREATETIME, B.UID, B.NAME, B.URL, A.SHOP " +
                    "FROM TB_SHOP_COMMENT A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.SHOP = ? ORDER BY A.CREATETIME DESC";
        }

        public static final class Reply {
            public static final String queryAppReplyList = "SELECT " +
                    "A.SRID,A.CONTENT,B.NAME,B.URL,A.CREATETIME FROM TB_SHOP_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B ON A.USER = B.UID " +
                    "WHERE A.SHOPCOMMENT = ? ORDER BY A.CREATETIME DESC";
        }
    }

    /**
     * 订单模块SQL
     */
    public static final class Order {
        public static final String getAppOrderListByParam = "select B.name, A.execTime, A.num, A.status, A.oid from TB_ORDER A " +
                "left outer join TB_SHOP B on A.shop = B.sid where 1=1 ";
        public static final String getOrderListByParam = "From Order A left join fetch A.shop B " +
                "left join fetch A.user C left join fetch B.area D where 1=1 ";
        public static final String getOrderListByParamOrder = " order by A.status asc, A.createTime desc";
    }

    public static final class Find {

        public static final String queryAppFindList = "SELECT " +
                "A.FID, B.UID, B.NAME AS USERNAME, B.URL, A.CREATETIME, A.CONTENT, C.SID, C.NAME, " +
                "(SELECT D.url FROM TB_SHOP_IMAGE D WHERE D.SHOP = C.SID AND C.TYPE = " + Consts.Shop.ImageType.Big + " ORDER BY C.SORT DESC LIMIT 1) AS IMAGE, " +
                "(SELECT COUNT(*) FROM TB_FIND_REPLY D WHERE D.FIND = A.FID) AS REPLYNUM " +
                "FROM TB_FIND A LEFT OUTER JOIN TB_USER B ON A.USER = B.UID " +
                "LEFT OUTER JOIN TB_SHOP C ON A.SHOP = C.SID " +
                "ORDER BY A.CREATETIME DESC";

        public static final class Reply {
            public static final String queryAppReplyList = "SELECT " +
                    "A.FRID,A.CONTENT,B.NAME,B.URL,A.CREATETIME FROM TB_FIND_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B ON A.USER = B.UID " +
                    "WHERE A.FIND = ? ORDER BY A.CREATETIME DESC";
        }
    }

    public static final class AppVer {
        // 获取app版本列表
        public static final String getAppVerList = "From AppVer A order by A.createTime desc";
        // 根据手机类型返回最新版本号
        public static final String getNewAppVer = "From AppVer A where A.type = ? order by A.createTime desc";
    }


    public static final class Market {

        public static final class Ad {
            // 获取广告列表
            public static final String getAdList = "From Ad A left join fetch A.shop B order by A.stopTime asc";
            // 查询app上滚动播放的广告
            public static final String getAppAdList =
                    "select A.adid, A.url, A.shop, A.STOPTIME from TB_AD A " +
                            "where A.stopTime > ? and A.type = ? order by A.sort desc";
            // 初始化APP后下载广告
            public static final String getAppAdListUpdateTime =
                    "SELECT A.ADID, A.TYPE, A.URL, A.SHOP, A.STARTTIME, A.STOPTIME, A.SORT " +
                            "FROM TB_AD WHERE A.CREATETIME > ?";
        }
    }


    public static final class Party {

        public static final String getPartyList = "From Party A order By A.stopTime";

        public static final String getAppPartyList =
                "select A.PID, A.URL, A.lOOKNUM, A.TITLE, " +
                        "(select B.price from TB_PARTY_MEET B where A.TYPE = " + Consts.Party.Type.Offline + " and B.PMID = A.CHILDID limit 1) as PRICE " +
                        "from TB_PARTY A where A.STOPTIME > ? and A.STARTTIME < ? " +
                        "order by A.sort desc";
    }


    public static final class Stat {

        public static final class User {
            // 统计过去30天用户注册量
            public static final String statUserRegStat =
                    "select A.YEAR, A.MONTH, A.DAY, A.NUM from TB_USER_REG_STAT A order by A.URSID desc limit 30";
        }

    }
}
