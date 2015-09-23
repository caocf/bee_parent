package com.bee.commons;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Consts {

    public static final boolean isDebug = true;
    private static final String LocalBaseUrl = "http://localhost:8080";
    private static final String RemoteBaseUrl = "http://139.196.27.231";

    public static String getBaseUrl() {
        return isDebug ? LocalBaseUrl : RemoteBaseUrl;
    }

    public static final int True = 0x1;
    public static final int False = 0x0;

    public static final int Android = 0x1;
    public static final int IOS = 0x2;

    public static class User {

        // 用户编号从1000开始
        public static final int IdentityBaseNum = 1000;

        public static final class Type {
            public static final int AdminUser = 0x0;
            public static final int AppUser = 0x1;
            public static final int VipUser = 0x2;
            public static final int PinkUser = 0x3;
            public static final int BussUser = 0x10;
        }

    }

    public static final class Shop {

        public static final class Type {
            // 会所
            public static final int Club = 0;
            // 足浴
            public static final int Massage = 1;
            // 夜总会
            public static final int Ktv = 2;
            // 酒吧
            public static final int Bar = 3;
            // 游艺
            public static final int Game = 4;

            public static Map<Integer, String> Select() {
                Map<Integer, String> ret = new LinkedHashMap<Integer, String>();
                ret.put(Club, "会所");
                ret.put(Massage, "足浴");
                ret.put(Ktv, "夜总会");
                ret.put(Bar, "酒吧");
                ret.put(Game, "游艺");
                return ret;
            }
        }

        public static final class Status {
            // 运营中
            public static final int Run = 1;
            // 关闭中
            public static final int Close = 0;
        }

        public static final class ErrorStatus {
            // 普通状态
            public static final int New = 1;
            // 进行中
            public static final int Doing = 2;
            // 结束状态
            public static final int End = 3;
        }

        public static final class ImageType {
            // 主图
            public static final int Big = 0;
            // 相册图
            public static final int Photo = 2;
        }
    }

    public static final class Order {

        public static final class Type {
            // 主订单
            public static final int Master = 0x1;
            // 子订单
            public static final int Child = 0x2;
        }

        public static final String ExecTimeType = "yyyy-MM-dd HH:mm";

        public static final class Status {

            // 未知状态
            public static final int Unknow = 0;

            // 等待到店
            public static final int Create = 1;
            // 到店进行中
            public static final int Underway = 10;
            // 完成
            public static final int Finish = 50;
            // 用户取消
            public static final int CancelUser = 90;
            // 商家取消
            public static final int CancelShop = 91;
            // 管理员取消
            public static final int CancelAdmin = 92;

            public static final String CreateStr = "等待到店";
            public static final String UnderwayStr = "进行中";
            public static final String FinishStr = "已完成";
            public static final String CancelUserStr = "已取消";
            public static final String CancelShopStr = "商家取消";
            public static final String CancelAdminStr = "管理员取消";

            public static String getStatusName(int status) {
                String ret;
                switch (status) {
                    case Consts.Order.Status.Create:
                        ret = Consts.Order.Status.CreateStr;
                        break;
                    case Consts.Order.Status.Underway:
                        ret = Consts.Order.Status.UnderwayStr;
                        break;
                    case Consts.Order.Status.Finish:
                        ret = Consts.Order.Status.FinishStr;
                        break;
                    case Consts.Order.Status.CancelUser:
                        ret = Consts.Order.Status.CancelUserStr;
                        break;
                    case Consts.Order.Status.CancelAdmin:
                        ret = Consts.Order.Status.CancelAdminStr;
                        break;
                    case Consts.Order.Status.CancelShop:
                        ret = Consts.Order.Status.CancelShopStr;
                        break;
                    default:
                        ret = "未知";
                        break;
                }
                return ret;
            }

            public static final class Query {
                // 新订单
                public static final int New = 1;
                // 正在进行订单
                public static final int Ing = 2;
                // 已完成订单
                public static final int Finish = 3;
                // 监控订单
                public static final int Monitor = 10;
                // 取消订单
                public static final int Cancel = 5;
                /**
                 * 返回查询状态SQL语句
                 */
                public static String getQueryStatus(int queryStatus) {
                    String query = " > 0";
                    switch(queryStatus) {
                        case Query.New:
                            query = " = " + Create;
                            break;
                        case Query.Monitor:
                            query = " <= " + Underway;
                            break;
                        case Query.Ing:
                            query = " <= " + Finish;
                            break;
                        case Query.Finish:
                            query = " = " + Consts.Order.Status.Finish;
                            break;
                        case Query.Cancel:
                            query = " > " + Consts.Order.Status.Finish;
                            break;
                    }
                    return query;
                }

            }

        }
    }

    /**
     * 发现
     */
    public static final class Find {
        public static final class Type {
            // 未知
            public static final int Unknow = 0x0;
            // 新店加入
            public static final int ShopNew = 0x1;
            // 商家推广
            public static final int ShopPop = 0x2;
        }
    }

    public static final class Ad {
        public static final class Type {
            public static final int Home = 0;
            public static final int Party = 1;
        }
    }

    public static final class AppType {
        public static final int Android = 1;
        public static final int iOS = 2;
    }

    public static final class Party {
        public static final class Type {
            public static final int Offline = 1;
        }
    }
}
