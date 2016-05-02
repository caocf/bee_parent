package com.bee.commons;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by suntongwei on 15/4/15.
 */
public final class Consts {

    public static final boolean isDebug = true;
    private static final String LocalBaseUrl = "http://localhost:8080";
    private static final String RemoteBaseUrl = "http://139.196.27.231";
    // video硬盘存放路径
    private static final String RemoteVideoPath = "/home/static/video";
    // app下载硬盘路径
    public static final String RemoteAppDownloadPath = "/home/static/app";

    public static String getBaseUrl() {
        return isDebug ? LocalBaseUrl : RemoteBaseUrl;
    }
    public static String GetRemoteImageUrl() {
        return RemoteBaseUrl;
    }
    // 获取视频存放路径
    public static String GetRemoteVideoFilePath() {
        return RemoteVideoPath;
    }

    public static final int True = 0x1;
    public static final int False = 0x0;

    public static final int Android = 0x1;
    public static final int IOS = 0x2;
    public static final int AndroidForBusi = 3;

    public static Map<Integer, String> GetAppVerSelect() {
        Map<Integer, String> ret = new LinkedHashMap<>();
        ret.put(Android, "Android");
        ret.put(IOS, "iOS");
        ret.put(AndroidForBusi, "商务端");
        return ret;
    }


    /**
     * 系统配置
     */
    public static final class Config {
        // 客服电话
        public static final String ServicePhone = "13162725286";

        // 地区类型标识
        public static final int Area = 0x1;
        // 首页广告更新
        public static final int MainAd = 0x2;
        // 发现广告更新
        public static final int FindAd = 0x3;
        // 二维码更新
        public static final int Qr = 0x4;
    }

    public static final class HXConfig {

        // 系统管理员的环信ID
        public static final String SystemAdminHXName = "1001";

    }

    public static final class User {

        // 用户编号从1000开始
        public static final int IdentityBaseNum = 1000;

        // 商户端用户初始密码
        public static final String BusiInitPassword = "000000";

        public static final class Type {
            public static final int AdminUser = 0x0;
            public static final int AppUser = 0x1;
            public static final int VipUser = 0x2;
            public static final int PinkUser = 0x3;
            public static final int BusiUser = 0x10;
            public static final int TestUser = 0x63;

            public static final Map<Integer, String> Select() {
                Map<Integer, String> ret = new HashMap<>();
                ret.put(Type.AppUser, "普通用户");
                ret.put(Type.BusiUser, "商家用户");
                ret.put(Type.VipUser, "VIP用户");
                ret.put(Type.AdminUser, "管理员");
                ret.put(Type.TestUser, "测试用户");
                return ret;
            }
        }

        public static final class Message {

            public static final class Type {
                public static final int System = 0x1;
            }

            public static final class Status {
                public static final int UnRead = 0x0;
                public static final int Read = 0x1;
            }
        }
    }

    public static final class Ticket {

        public static final class Status {
            public static final int UnKnow = 0x0;
            public static final int Normal = 0x1;
            public static final int Useing = 0x2;
            public static final int Used = 0x3;
            public static final int Expired = 0x4;
        }

        public static final class Type {
            // 减免
            public static final int Normal = 0x1;
            // 全免
            public static final int Free = 0x2;

            public static final Map<Integer, String> Select() {
                Map<Integer, String> ret = new HashMap<>();
                ret.put(Type.Normal, "减免类型");
                ret.put(Type.Free, "全免类型");
                return ret;
            }
        }
    }

    /**
     * 商家
     */
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
                return ret;
            }
        }

        public static final class Status {
            // 运营中
            public static final int Run = 1;
            // 暂停中（由商家发起）
            public static final int Pause = 2;
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

        public static final class Image {

            public static final String ShowImageNumberForAppShop = " limit 15";

            public static final int MaxUploadImageSize = 300;

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


        public static final class Operate {
            public static final String Create = "创建订单";
            public static final String UserCancel = "用户取消订单";
            public static final String ShopCancel = "商户取消订单";
            public static final String ShopReject = "商户拒绝订单";
            public static final String AdminCancel = "管理员取消订单";
            public static final String Underway = "商家接受订单";
            public static final String Finish = "订单完成";
            public static final String Edited = "用户修改了订单人数";
        }

        public static final class Status {

            // 未知状态
            public static final int Unknow = 0;
            // 等待接单
            public static final int Create = 1;
            // 进行中
            public static final int Underway = 10;
            // 完成
            public static final int Finish = 50;
            // 用户取消
            public static final int CancelUser = 90;
            // 商家取消
            public static final int CancelShop = 91;
            // 管理员取消
            public static final int CancelAdmin = 92;
            // 商家拒绝订单
            public static final int ShopReject = 93;

            public static final String CreateStr = "等待接单";
            public static final String UnderwayStr = "进行中";
            public static final String FinishStr = "已完成";
            public static final String CancelUserStr = "已取消";
            public static final String CancelShopStr = "商家取消";
            public static final String CancelAdminStr = "管理员取消";
            public static final String ShopRejectStr = "商家拒绝订单";

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
                    case Consts.Order.Status.ShopReject:
                        ret = Consts.Order.Status.ShopRejectStr;
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
                // 取消订单
                public static final int Cancel = 5;
                // 历史订单
                public static final int History = 6;
                // 商户端进行中
                public static final int BusiFinish = 7;
                /**
                 * 返回查询状态SQL语句
                 */
                public static String getQueryStatus(int queryStatus) {
                    String query = " > 0";
                    switch(queryStatus) {
                        case Query.New:
                            query = " = " + Status.Create;
                            break;
                        case Query.Ing:
                            query = " < " + Status.Finish;
                            break;
                        case Query.Finish:
                            query = " = " + Status.Finish;
                            break;
                        case Query.Cancel:
                            query = " > " + Status.Finish;
                            break;
                        case Query.History:
                            query = " >= " + Status.Finish;
                            break;
                    }
                    return query;
                }

                public static String getQueryString(String column, int queryStatus) {
                    String query = column + " > 0";
                    switch(queryStatus) {
                        case Query.Ing:
                            query = column + " < " + Status.Finish;
                            break;
                        case Query.Finish:
                            query = column + " = " + Status.Finish;
                            break;
                        case Query.Cancel:
                            query = column + " > " + Status.Finish;
                            break;
                        case Query.BusiFinish:
                            query = column + " = " + Status.Underway;
                            break;
                        case Query.History:
                            query = column + " >= " + Status.Finish;
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

            public static Map<Integer, String> Select() {
                Map<Integer, String> ret = new LinkedHashMap<>();
                ret.put(ShopNew, "新店加入");
                ret.put(ShopPop, "商家发布");
                return ret;
            }
        }

        public static final class Image {
            // 商家相册图片
            public static final int ShopImage = 0x1;
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
        public static final int AndroidForBusi = 3;
    }

    public static final class Party {
        public static final class Type {
            public static final int Online = 1;
            public static final int Offline = 2;
        }

        public static final class Status {
            // 未开始
            public static final int Create = 0x1;
            // 进行中
            public static final int Ing = 0x2;
            // 已结束
            public static final int Finish = 0x3;
        }
    }


    /**
     *
     */
    public static final class Goods {

        public static final class Type {
            // 实体物品
            public static final int Entity = 1;
            // 虚拟物品
            public static final int Virtual = 2;

            public static Map<Integer, String> Select() {
                Map<Integer, String> ret = new HashMap<>();
                ret.put(Type.Entity, "实体物品");
                ret.put(Type.Virtual, "虚拟物品");
                return ret;
            }
        }

        public static final class Status {

            public static final int Online = 0x1;

            public static final int Offline = 0x0;
        }


        public static final class PhoneCard {

            public static final class Status {
                public static final int UnUse = 1;
                public static final int Used = 0;
            }


        }
    }


    /**
     * 运营商
     */
    public static final class Operator {
        public static final int ChinaMobile = 1;
        public static final int ChinaUnicom = 2;
        public static final int ChinaTelecom = 3;
    }


    public static final Map<Integer, String> GetOperatorSelect() {
        Map<Integer, String> ret = new HashMap<>();
        ret.put(Operator.ChinaMobile, "中国移动");
        ret.put(Operator.ChinaUnicom, "中国联通");
        ret.put(Operator.ChinaTelecom, "中国电信");
        return ret;
    }

}