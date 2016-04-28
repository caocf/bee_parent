package com.bee.commons;

/**
 * Created by suntongwei on 15/4/16.
 */
public final class SQL {


    public static final class SystemConfig {

        public static final String GetSystemConfigAll = "SELECT " +
                "A.SCID, A.TYPE, A.FLAG " +
                "From TB_SYSTEM_CONFIG A";

        public static final String GetSystemConfig = "SELECT " +
                "A.SCID, A.TYPE, A.FLAG " +
                "From TB_SYSTEM_CONFIG A where A.type = ?";

    }

    public static final class Area {
        public static final String queryAreaById = "From Area A where A.parentId = ? order by A.sort desc";
        public static final String getAreaByLastId = "From Area A where A.aid > ?";
    }


    public static final class User {

        // 查询用户
        public static final String QueryUserByParams = "From User A WHERE 1=1";

        public static final String GetUserLoginByParam = "From User A left join fetch A.userAuths B WHERE 1=1";

        // 根据帐号查询用户
        public static final String queryUserByAccount = "From User A left join fetch A.userAuths B where A.phone = ?";
        public static final String queryUserByNick = "From User A where A.name = ?";

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

        public static final class Message {
            // 获取用户未读消息
            public static final String GetUserMessage = "SELECT " +
                    "A.MID, A.MSG, A.TYPE, A.CREATETIME, A.USER, A.STATUS " +
                    "FROM TB_MESSAGE A WHERE 1=1";
            // 删除指定用户所有消息
            public static final String DeleteMessageByUser = "DELETE FROM TB_MESSAGE WHERE USER = ?";
        }

        public static final class Ticket {

            // 获取用户所有优惠券信息
            public static final String GetUserTickets = "SELECT " +
                    "A.UTID, B.TID, A.STATUS, B.TITLE, C.SID, C.NAME, A.STARTTIME, A.STOPTIME, B.PRICE, B.TYPE " +
                    "FROM TB_USER_TICKET A " +
                    "LEFT OUTER JOIN " +
                    "TB_TICKET B " +
                    "ON " +
                    "A.TICKET = B.TID " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP C " +
                    "ON " +
                    "B.SHOP = C.SID " +
                    "WHERE 1=1";

            public static final String GetOrderTicket = "From UserTicket A " +
                    "LEFT JOIN FETCH A.ticket B LEFT JOIN FETCH B.shop C WHERE 1=1";

            public static final String MateUserTicket = "UPDATE " +
                    "TB_USER_TICKET A " +
                    "SET " +
                    "A.STATUS = " + Consts.Ticket.Status.Expired + " " +
                    "WHERE " +
                    "A.STATUS = ? AND A.STOPTIME < ? AND A.STOPTIME > 0";
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
                "A.SID, A.NAME, A.ADDR, A.PRICE, B.NAME AS AREA," +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as FOCUSNUM, " +
                "A.TYPE, A.ISBEESHOP " +
                "FROM TB_SHOP A " +
                "left outer join TB_AREA B " +
                "on A.area = B.aid " +
                "where A.recommend = " + Consts.True + " and A.status = " + Consts.Shop.Status.Run + " order by A.sort desc limit 6";

        // 查询商家列表App
        public static final String ShopListApp =
                "SELECT " +
                "A.SID, A.NAME, A.ADDR, A.PRICE, B.NAME AS AREA, " +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as FOCUSNUM," +
                " A.TYPE, A.ISBEESHOP " +
                "FROM TB_SHOP A " +
                "LEFT OUTER JOIN TB_AREA B " +
                "ON A.AREA = B.AID  " +
                "WHERE A.STATUS = " + Consts.Shop.Status.Run;
        public static final String queryAppShopListSort = " order by A.sort desc";

        /**
         * 查询商家详细
         */
        public static final String QueryAppShopItem =
                "SELECT " +
                "A.SID, A.NAME, A.ADDR, A.PRICE, B.NAME AS AREA, " +
                "(select count(*) from TB_SHOP_FOCUS D where D.shop = A.sid) as focusNum," +
                "A.LON, A.LAT, A.TYPE, A.SERVICETIME, A.ISFREEPARKING, A.ISFOOD, A.ISINVOICE, A.ISPOSCARD " +
                "FROM TB_SHOP A " +
                "LEFT OUTER JOIN TB_AREA B " +
                "ON A.AREA = B.AID " +
                "LEFT OUTER JOIN TB_SHOP_CONFIG C " +
                "ON A.SID = C.SHOP " +
                "WHERE A.STATUS = " + Consts.Shop.Status.Run;


        // 查询商家地图
        public static final String queryShopMap = "SELECT A.SID, A.NAME, A.ADDR, A.LON, A.LAT FROM TB_SHOP A";

        /**
         * 商家管理员
         */
        public static final class Admin {

            public static final String queryShopAdminList = "From ShopUser A " +
                    "LEFT JOIN FETCH A.shop B " +
                    "LEFT JOIN FETCH A.user C " +
                    "WHERE B.sid = ?";
        }

        public static final class Price {
            public static final String queryAppShopPriceByShopId = "SELECT A.PRICE, A.MARK FROM TB_SHOP_PRICE A WHERE A.SHOP = ?";
            public static final String queryShopPriceByShopId = "From ShopPrice A left join fetch A.shop B where B.sid = ?";
            public static final String getShopPriceById = "From ShopPrice A left join fetch A.shop B where A.spid = ?";
        }

        public static final class Image {

            public static final String QueryShopImageApp = "SELECT " +
                    "A.SIID, A.URL, A.REMARK, A.WIDTH, A.HEIGHT " +
                    "FROM TB_SHOP_IMAGE A " +
                    "WHERE 1=1 ";

            public static final String queryAppShopImage = "SELECT " +
                    "A.URL,A.REMARK,A.WIDTH, A.HEIGHT, A.SIID " +
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
            public static final String GetFocusShop = "From ShopFocus A where shop.sid = ? and user.uid = ?";
            public static final String GetShopFocusList = "SELECT " +
                    "A.SID, A.NAME " +
                    "FROM TB_SHOP A " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP_FOCUS B " +
                    "ON A.SID = B.SHOP " +
                    "LEFT OUTER JOIN " +
                    "TB_USER C " +
                    "ON B.USER = C.UID " +
                    "WHERE C.UID = ? " +
                    "ORDER BY B.CREATETIME DESC";

            public static final String GetShopFocusListByParam = "SELECT " +
                    "A.SID, A.NAME, B.CREATETIME, A.STATUS " +
                    "FROM TB_SHOP A " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP_FOCUS B " +
                    "ON A.SID = B.SHOP " +
                    "WHERE 1=1";
        }

        public static final class Comment {
            public static final String getAppCommentList = "SELECT " +
                    "A.SCID, A.CONTENT, A.CREATETIME, B.UID, B.NAME, A.SHOP, A.REPLYNUM, B.LEVEL " +
                    "FROM TB_SHOP_COMMENT A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.SHOP = ? ORDER BY A.CREATETIME DESC";

            public static final String QueryShopCommentOrderBy = " ORDER BY A.scid DESC";
        }

        public static final class Reply {
            public static final String queryAppReplyList = "SELECT " +
                    "A.SRID,A.CONTENT,B.NAME,B.UID,A.CREATETIME, B.LEVEL " +
                    "FROM TB_SHOP_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.SHOPCOMMENT = ? ORDER BY A.SRID DESC";
        }

        public static final class User {

            public static final String GetShopUserById = "From ShopUser A " +
                    "left join fetch A.shop B " +
                    "left join fetch A.user C where A.suid = ?";

            public static final String getShopUserByShopId = "FROM ShopUser A " +
                    "left join fetch A.shop B " +
                    "left join fetch A.user C where B.sid = ?";

            public static final String GetShopUserByLogin = "SELECT " +
                    "B.SID, B.NAME, B.STATUS, C.UID, C.`NAME` AS USERNAME, C.PHONE " +
                    "FROM TB_SHOP_USER A " +
                    "LEFT OUTER JOIN TB_SHOP B " +
                    "ON A.SHOP = B.SID " +
                    "LEFT OUTER JOIN TB_USER C " +
                    "ON A.USER = C.UID " +
                    "WHERE C.UID = ?";
        }

        /**
         * 商家组
         */
        public static final class Group {

            public static final String QueryAdminShopGroupList = "FROM " +
                    "ShopGroup A LEFT JOIN FETCH A.shop B WHERE B.sid = ?";


            public static final String GetShopGroupMinPrice = "SELECT " +
                    "A.GROUPNAME, A.PRICE FROM TB_SHOP_GROUP A " +
                    "WHERE A.SHOP = ? ORDER BY A.PRICE ASC LIMIT 1";


            public static final String GetShopGroupByShopId = "SELECT " +
                    "A.SGID, A.GROUPNAME, A.SHOP, A.PRICE, A.REMARK " +
                    "FROM TB_SHOP_GROUP A " +
                    "WHERE A.SHOP = ?";

            public static final String QueryShopPriceByShopId = "SELECT " +
                    "A.GROUPNAME, A.PRICE, A.REMARK " +
                    "FROM TB_SHOP_GROUP A " +
                    "WHERE A.SHOP = ?";
        }

        /**
         * 商家技师
         */
        public static final class Techee {

            /**
             * 返回所属ShopGroup的所有ShopTechee
             */
            public static final String GetShopTecheeByGroupId = "From ShopTechee A where A.shopGroup.sgId = ?";

            /**
             * 返回所属商家的所有ShopTechee
             */
            public static final String GetShopTecheeByShopId = "SELECT " +
                    "A.STID, A.NUMBER, A.SHOPGROUP, A.SHOP, B.GROUPNAME " +
                    "FROM TB_SHOP_TECHEE A " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP_GROUP B " +
                    "ON A.SHOPGROUP = B.SGID " +
                    "WHERE A.SHOP = ?";

        }

        /**
         * 商家出勤表
         */
        public static final class Attend {

            public static final String GetShopAttendLastUpdateTime = "From " +
                    "ShopAttend A where A.shop.sid = ? order by A.saId desc";

            public static final String GetShopAttendByShopId = "SELECT " +
                    "A.SAID, A.SHOPTECHEE, A.ATTENDTIME, A.SHOP " +
                    "FROM TB_SHOP_ATTEND A WHERE A.SHOP = ? AND A.ATTENDTIME = ?";


            public static final String GetShopAttendByShopIdForApp = "SELECT " +
                    "B.NUMBER, C.GROUPNAME " +
                    "FROM TB_SHOP_ATTEND A " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP_TECHEE B " +
                    "ON A.SHOPTECHEE = B.STID " +
                    "LEFT OUTER JOIN " +
                    "TB_SHOP_GROUP C " +
                    "ON B.SHOPGROUP = C.SGID " +
                    "WHERE A.SHOP = ? AND A.ATTENDTIME = ?";


            public static final String GetShopAttendByShopIdAfter = "SELECT " +
                    "A.SAID, A.SHOPTECHEE, A.ATTENDTIME, A.SHOP " +
                    "FROM TB_SHOP_ATTEND A WHERE A.SHOP = ? AND A.ATTENDTIME >= ?";


            public static final String DeleteShopAttend = "DELETE FROM TB_SHOP_ATTEND " +
                    "WHERE SHOP = ? AND ATTENDTIME = ?";
        }


        public static final class Update {

            public static final String GetShopUpdateByShopId = "From ShopUpdate A where A.shop.sid = ?";
        }
    }

    /**
     * 订单模块SQL
     */
    public static final class Order {

        // 返回包含用户信息的订单
        public static final String GetOrder = "From Order A " +
                "left join fetch A.user B where B.uid = ?";

        // 返回订单详细信息
        public static final String GetOrderDetailByOid = "From Order A " +
                "left join fetch A.shop B " +
                "left join fetch A.user C " +
                "left join fetch B.area D " +
                "left join fetch A.shopUser E " +
                "where A.oid = ?";

        /**
         * 根据参数查询订单，主要用于订单统计
         */
        public static final String QueryOrderByParams = "From Order A " +
                "left join fetch A.shop B where 1=1";

        public static final String getAppOrderListByParam = "SELECT " +
                "B.NAME, A.CREATETIME, A.NUM, A.STATUS, A.OID, B.SID, A.ORDERNAME, A.EXECTIME, " +
                "A.ORDERPHONE, A.REMARK, A.ISBACK " +
                "FROM TB_ORDER A LEFT OUTER JOIN TB_SHOP B ON A.SHOP = B.SID WHERE 1=1 ";
        public static final String getBusiOrderListByParam = "SELECT " +
                "A.OID, A.NO, A.STATUS, A.NUM, A.EXECTIME, A.ORDERNAME, B.UID, B.NAME, A.CREATETIME," +
                "(SELECT COUNT(*) FROM TB_ORDER O WHERE O.SHOP = ? AND O.USER = B.UID AND O.STATUS = " + Consts.Order.Status.Finish + ") AS 'HIS_NUMBER', " +
                "B.LEVEL " +
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

        public static final String getOrderListByParam = "From Order A " +
                "LEFT JOIN FETCH A.shop B " +
                "LEFT JOIN FETCH A.user C " +
                "LEFT JOIN FETCH B.area D " +
                "LEFT JOIN FETCH A.shopUser E where 1=1 ";
        public static final String getOrderListByParamOrder = " order by A.oid desc";

        /**
         *【C端】查询商家详细(ShopDetailActivity)
         */
        public static final String QueryOrderByOid = "SELECT " +
                "A.NO, A.CREATETIME, A.STATUS, C.ADDR, B.PHONE, A.ISCOMMENT, A.USER, C.LON, C.LAT " +
                "FROM TB_ORDER A " +
                "LEFT OUTER JOIN TB_SHOP_USER B ON A.SHOPUSER = B.SUID " +
                "LEFT OUTER JOIN TB_SHOP C ON A.SHOP = C.SID " +
                "WHERE A.OID = ?";

        /**
         * 【A端】删除商家管理员对应的订单ID
         */
        public static final String DeleteShopUser = "UPDATE TB_ORDER A SET A.SHOPUSER = 0 WHERE A.SHOPUSER = ?";

        /**
         * 统计
         */
        public static final class Stat {

            public static final String QueryBusiOrderNumberStat = "SELECT " +
                    "SUM(A.NUM) FROM TB_ORDER A " +
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
        public static final String QueryFindAppList = "SELECT " +
                "A.FID, B.UID, A.TYPE, B.NAME AS USERNAME, A.CREATETIME, A.CONTENT, C.SID, C.NAME, " +
                "(SELECT COUNT(*) FROM TB_FIND_REPLY D WHERE D.FIND = A.FID) AS REPLYNUM " +
                "FROM TB_FIND A " +
                "LEFT OUTER JOIN TB_USER B ON A.USER = B.UID " +
                "LEFT OUTER JOIN TB_SHOP C ON A.SHOP = C.SID " +
                "WHERE C.STATUS = " + Consts.Shop.Status.Run;

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
                    "A.FRID,A.CONTENT,B.NAME,B.UID,A.CREATETIME, B.LEVEL " +
                    "FROM TB_FIND_REPLY A " +
                    "LEFT OUTER JOIN TB_USER B " +
                    "ON A.USER = B.UID " +
                    "WHERE A.FIND = ? ORDER BY A.CREATETIME DESC";
        }

        public static final class Image {

            // 根据发现ID查询发现图片中的所有商家图片
            public static final String QueryShopImageByFind = "SELECT " +
                    "B.SIID, B.URL, B.REMARK, B.WIDTH, B.HEIGHT " +
                    "FROM TB_FIND_IMAGE A " +
                    "LEFT OUTER JOIN TB_SHOP_IMAGE B " +
                    "ON A.SHOPIMAGE = B.SIID " +
                    "WHERE A.FIND = ?";
        }
    }

    public static final class AppVer {
        // 获取app版本列表
        public static final String getAppVerList = "From AppVer A order by A.createTime desc";
        // 根据手机类型返回最新版本号
        public static final String getNewAppVer = "From AppVer A where A.type = ? order by A.avid desc";
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

    public static final class Ticket {

        public static final String GetTicketWithShop = "From Ticket A LEFT JOIN FETCH A.shop B";

        public static final String GetUserTicketByOrder = "From UserTicket A where A.order.oid = ?";
    }

    public static final class Party {

        public static final String GetPartyList = "SELECT " +
                "A.PID, A.TYPE, A.PARTYTIME, A.STARTTIME, A.STOPTIME, A.ISBEE, A.TITLE, A.CONTENT " +
                "FROM TB_PARTY A";
        public static final String GetPartyListOrderBy = " order by A.SORT DESC";

        public static final class User {
            // 查询活动用户
            public static final String QueryPartyUser = "From PartyUser A " +
                    "LEFT JOIN FETCH A.party B LEFT JOIN FETCH A.user C WHERE 1=1";
        }

        public static final class Condition {
            // 获取报名条件
            public static final String GetCondition = "From PartyCondition A WHERE A.party.pid = ?";
        }

    }


    public static final class Stat {

        public static final String QueryUserLoginStatByParam = "From UserLoginStat A WHERE 1=1";
    }

    /**
     *
     */
    public static final class Store {

        public static final String QueryGoodsList = "SELECT " +
                "A.GID, A.NAME, A.INTEGRAL, A.NUMBER " +
                "FROM TB_GOODS A ";

        public static final String GetGoodsList = "From Goods A";


        public static final String GetEffectivePhoneCard = "FROM " +
                "PhoneCard A " +
                "WHERE A.status = " + Consts.Goods.PhoneCard.Status.UnUse + " AND A.operator = ? " +
                "ORDER BY A.pcId ASC ";


        public static final String QueryUserConverList = "SELECT " +
                "A.CARDNUMBER, A.CREATETIME, B.NAME, B.INTEGRAL " +
                "FROM TB_USER_CONVERT A " +
                "LEFT OUTER JOIN " +
                "TB_GOODS B " +
                "ON A.GOODS = B.GID " +
                "WHERE A.USER = ? " +
                "ORDER BY A.CREATETIME DESC";


        public static final class PhoneCard {

            public static final String QueryPhoneCard = "From PhoneCard A where 1=1";


        }

    }

}
