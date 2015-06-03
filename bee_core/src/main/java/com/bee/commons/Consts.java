package com.bee.commons;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Consts {

    public static final boolean isDebug = true;
    private static final String LocalBaseUrl = "http://localhost:8080";
    private static final String RemoteBaseUrl = "http://120.26.103.71";

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

            public static Map<Integer, String> Select() {
                Map<Integer, String> ret = new LinkedHashMap<Integer, String>();
                ret.put(Club, "会所");
                ret.put(Massage, "足浴");
                ret.put(Ktv, "夜总会");
                ret.put(Bar, "酒吧");
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
            // 副图
            public static final int Thumbnail = 1;
            // 相册图
            public static final int Photo = 2;
        }
    }

    public static final class Order {

        public static final String ExecTimeType = "yyyy-MM-dd HH:mm";

        public static final class Status {
            // 等待确认
            public static final int Execute = 1;
            // 等待到店
            public static final int Progress = 10;
            // 已取消
            public static final int Cancel = 50;
            // 商家取消
            public static final int ShopCancel = 51;
            // 完成
            public static final int Finish = 99;

            public static final class Query {
                // 正在进行订单
                public static final int Ing = 1;
                // 已完成订单
                public static final int Finish = 2;
                // 监控订单
                public static final int Monitor = 10;
                // 取消订单
                public static final int Cancel = 3;
                /**
                 * 返回查询状态SQL语句
                 */
                public static String getQueryStatus(int queryStatus) {
                    String query = " > 0";
                    switch(queryStatus) {
                        case Query.Monitor:
                            query = " = 1";
                            break;
                        case Query.Ing:
                            query = " < 50";
                            break;
                        case Query.Finish:
                            query = " >= 50";
                            break;
                        case Query.Cancel:
                            query = " = 51";
                            break;
                    }
                    return query;
                }

            }

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
