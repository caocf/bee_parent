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

        // 查询用户实时数据
        public static final String QueryUserInfo = "SELECT " +
                "A.UID, A.LEVEL, A.INTEGRAL " +
                "FROM TB_USER A WHERE A.UID = ?";

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

        public static final String queryShopById = "From Shop A left join fetch A.area B where A.sid = ?";

        // 查询商家列表
        public static final String queryShopList = "From Shop A left join fetch A.area B where 1=1";
        public static final String queryShopListSort = " order by A.sort desc";

        // 查询推荐商家
        public static final String queryRecommendShop =
                "select " +
                "A.sid,A.name,A.addr,A.price,B.name as area," +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "(select count(*) from TB_USER_FRIEND E left outer join TB_SHOP_FOCUS F on E.FRIEND = F.USER where F.shop = A.sid and E.user = ?) as friendNum, " +
                "A.lon, A.lat, A.phone, A.type, A.linkName, A.remark, A.isBack " +
                "from TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid " +
                "where A.recommend = " + Consts.True + " and A.status = " + Consts.Shop.Status.Run + " order by A.sort desc limit 6";

        // 查询好友关注数
        public static final String queryAppShopList =
                "select " +
                "A.sid,A.name,A.addr,A.price,B.name as area, " +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "(select count(*) from TB_USER_FRIEND E left outer join TB_SHOP_FOCUS F on E.FRIEND = F.USER where F.shop = A.sid and E.user = ?) as friendNum, " +
                "A.lon, A.lat, A.phone, A.type, A.linkName, A.remark, A.isBack " +
                "from TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid  " +
                "where A.status = " + Consts.Shop.Status.Run;
        public static final String queryAppShopListSort = " order by A.sort desc";

        // 查询商家地图
        public static final String queryShopMap = "SELECT A.SID, A.NAME, A.ADDR, A.LON, A.LAT FROM TB_SHOP A";

        public static final class Price {
            public static final String queryAppShopPriceByShopId = "SELECT A.PRICE, A.MARK FROM TB_SHOP_PRICE A WHERE A.SHOP = ?";
            public static final String queryShopPriceByShopId = "From ShopPrice A left join fetch A.shop B where B.sid = ?";
            public static final String getShopPriceById = "From ShopPrice A left join fetch A.shop B where A.spid = ?";
        }

        public static final class Image {
            public static final String queryAppShopImage = "SELECT " +
                    "A.URL,A.REMARK,A.WIDTH, A.HEIGHT " +
                    "FROM TB_SHOP_IMAGE A WHERE A.SHOP = ? " +
                    "ORDER BY A.SORT DESC";
            public static final String queryShopImageByShopId = "From ShopImage A left join fetch A.shop B where B.sid = ?";
            public static final String getShopImageById = "From ShopImage A left join fetch A.shop B where A.siid = ?";
        }

        public static final class Focus {
            public static final String getFocusList = "From ShopFocus A where A.shop.sid = ?";
            public static final String GetShopFocusFriend =
                    "select B.`NAME`, B.UID " +
                    "from TB_USER_FRIEND A left outer join TB_USER B on A.friend = B.uid " +
                    "left outer join TB_SHOP_FOCUS C on A.friend=C.`USER`" +
                    "where A.`USER` = ? and C.shop = ?";
        }

        public static final class Comment {
            public static final String getAppCommentList = "SELECT " +
                    "A.SCID, A.CONTENT, A.CREATETIME, B.UID, B.NAME, A.SHOP, " +
                    "(SELECT COUNT(*) FROM TB_SHOP_REPLY C WHERE C.SHOPCOMMENT = A.SCID) AS REPLY_NUM " +
                    "FROM TB_SHOP_COMMENT A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.SHOP = ? ORDER BY A.CREATETIME DESC";
        }

        public static final class Reply {
            public static final String queryAppReplyList = "SELECT " +
                    "A.SRID,A.CONTENT,B.NAME,B.UID,A.CREATETIME " +
                    "FROM TB_SHOP_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.SHOPCOMMENT = ? ORDER BY A.CREATETIME DESC";
        }

        public static final class User {
            public static final String getShopUserByShopId = "FROM ShopUser A " +
                    "left join fetch A.shop B " +
                    "left join fetch A.user C where B.sid = ?";

            public static final String GetShopUserByLogin = "SELECT " +
                    "B.SID, B.NAME, B.STATUS, C.UID, C.`NAME` AS USERNAME " +
                    "FROM TB_SHOP_USER A " +
                    "LEFT OUTER JOIN TB_SHOP B " +
                    "ON A.SHOP = B.SID " +
                    "LEFT OUTER JOIN TB_USER C " +
                    "ON A.USER = C.UID " +
                    "WHERE C.UID = ?";
        }
    }

    /**
     * 订单模块SQL
     */
    public static final class Order {
        public static final String getAppOrderListByParam = "SELECT " +
                "B.NAME, A.CREATETIME, A.NUM, A.STATUS, A.OID, B.SID, A.ORDERNAME, A.EXECTIME, " +
                "A.ORDERPHONE, A.REMARK " +
                "FROM TB_ORDER A LEFT OUTER JOIN TB_SHOP B ON A.SHOP = B.SID WHERE 1=1 ";
        public static final String getBusiOrderListByParam = "SELECT " +
                "A.OID, A.NO, A.STATUS, A.NUM, A.EXECTIME, A.ORDERNAME, B.UID, B.NAME, A.CREATETIME," +
                "(SELECT COUNT(*) FROM TB_ORDER O WHERE O.SHOP = ? AND O.USER = B.UID AND O.STATUS = " + Consts.Order.Status.Finish + ") AS 'HIS_NUMBER' " +
                "FROM TB_ORDER A " +
                "LEFT OUTER JOIN TB_USER B " +
                "ON A.USER = B.UID " +
                "LEFT OUTER JOIN TB_SHOP C " +
                "ON A.SHOP = C.SID " +
                "WHERE C.SID = ?";
        public static final String getBusiOrderListByParamOrderBy = " ORDER BY A.EXECTIME DESC";

        /**
         * 【B端】获取订单详细信息
         */
        public static final String GetBusiOrderItem = "SELECT " +
                "A.OID, A.`NO`, A.NUM, A.CREATETIME, A.EXECTIME, A.ORDERNAME, B.UID, B.NAME, A.ORDERPHONE, A.REMARK, " +
                "A.`STATUS`, B.LEVEL " +
                "FROM TB_ORDER A " +
                "LEFT OUTER JOIN TB_USER B " +
                "ON A.USER = B.UID " +
                "WHERE A.OID = ? ORDER BY A.EXECTIME DESC";

        public static final String getOrderListByParam = "From Order A left join fetch A.shop B " +
                "left join fetch A.user C left join fetch B.area D where 1=1 ";
        public static final String getOrderListByParamOrder = " order by A.status asc, A.createTime desc";

        /**
         *【C端】查询商家详细(ShopDetailActivity)
         */
        public static final String QueryOrderByOid = "SELECT " +
                "A.NO, A.CREATETIME, A.STATUS, C.ADDR, C.PHONE, A.ISCOMMENT " +
                "FROM TB_ORDER A " +
                "LEFT OUTER JOIN TB_SHOP_USER B ON A.SHOPUSER = B.SUID " +
                "LEFT OUTER JOIN TB_SHOP C ON A.SHOP = C.SID " +
                "WHERE A.OID = ?";

        /**
         * 统计
         */
        public static final class Stat {

            public static final String QueryBusiOrderNumberStat = "SELECT " +
                    "COUNT(*) FROM TB_ORDER A " +
                    "WHERE A.SHOP = ? " +
                    "AND A.FINISHTIME >= ? " +
                    "AND A.STATUS ";
        }
    }

    /**
     * 发现模块SQL
     */
    public static final class Find {

        // 查询发现列表
        public static final String queryAppFindList = "SELECT " +
                "A.FID, B.UID, A.TYPE, B.NAME AS USERNAME, A.CREATETIME, A.CONTENT, C.SID, C.NAME, " +
                "(SELECT COUNT(*) FROM TB_FIND_REPLY D WHERE D.FIND = A.FID) AS REPLYNUM " +
                "FROM TB_FIND A " +
                "LEFT OUTER JOIN TB_USER B ON A.USER = B.UID " +
                "LEFT OUTER JOIN TB_SHOP C ON A.SHOP = C.SID " +
                "ORDER BY A.CREATETIME DESC";

        public static final class Reply {
            public static final String queryAppReplyList = "SELECT " +
                    "A.FRID,A.CONTENT,B.NAME,B.UID,A.CREATETIME " +
                    "FROM TB_FIND_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
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

        public static final String GetAppPartyList =
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
