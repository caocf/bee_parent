package com.bee.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suntongwei on 15/11/8.
 */
public final class AuthName {

    /** 超级管理员权限 */
    public static final String SuperAdmin = "SUPER_ADMIN";

    public static final Map<String, String> AuthMap = new HashMap<>();


    public static final String Shop = "SHOP";
    public static final String ShopNew = "SHOP_NEW";
    public static final String ShopEdit = "SHOP_EDIT";
    public static final String ShopDelete = "SHOP_DELETE";


    public static final String ShopGroup = "SHOP_GROUP";
    public static final String ShopGroupNew = "SHOP_GROUP_NEW";
    public static final String ShopGroupEdit = "SHOP_GROUP_EDIT";
    public static final String ShopGroupDelete = "SHOP_GROUP_DELETE";

    public static final String ShopComment = "SHOP_COMMENT";
    public static final String ShopCommentNew = "SHOP_COMMENT_NEW";
    public static final String ShopCommentDelete = "SHOP_COMMENT_DELETE";

    public static final String ShopImage = "SHOP_IMAGE";
    public static final String ShopImageNew = "SHOP_IMAGE_NEW";
    public static final String ShopImageEdit = "SHOP_IMAGE_EDIT";
    public static final String ShopImageDelete = "SHOP_IMAGE_DELETE";

    public static final String ShopUser = "SHOP_USER";
    public static final String ShopUserNew = "SHOP_USER_NEW";
    public static final String ShopUserDelete = "SHOP_USER_DELETE";

    public static final String Order = "ORDER";
    public static final String OrderCreate = "ORDER_CREATE";
    public static final String OrderMonitor = "ORDER_MONITOR";
    public static final String OrderDelete = "ORDER_DELETE";

    public static final String User = "USER";

    public static final String Stat = "STAT";

    public static final String Area = "AREA";
    public static final String AreaNew = "AREA_NEW";
    public static final String AreaEdit = "AREA_EDIT";
    public static final String AreaDelete = "AREA_DELETE";

    static {
        AuthMap.put(Shop, "商家查看");
        AuthMap.put(ShopNew, "创建商家");
        AuthMap.put(ShopDelete, "删除商家");
        AuthMap.put(ShopEdit, "修改商家");
        AuthMap.put(ShopGroup, "商家组查看");
        AuthMap.put(ShopGroupNew, "创建商家组");
        AuthMap.put(ShopGroupEdit, "修改商家组");
        AuthMap.put(ShopGroupDelete, "删除商家组");
        AuthMap.put(ShopComment, "查看商家评论");
        AuthMap.put(ShopCommentNew, "发表商家评论");
        AuthMap.put(ShopCommentDelete, "删除商家评论");
        AuthMap.put(ShopImage, "查看商家图片");
        AuthMap.put(ShopImageNew, "上传商家图片");
        AuthMap.put(ShopImageEdit, "修改商家图片");
        AuthMap.put(ShopImageDelete, "删除商家图片");
        AuthMap.put(ShopUser, "查看商家管理员");
        AuthMap.put(ShopUserNew, "创建商家管理员");
        AuthMap.put(ShopUserDelete, "删除商家管理员");
        AuthMap.put(Order, "查看订单");
        AuthMap.put(OrderMonitor, "订单监控");
        AuthMap.put(OrderDelete, "取消订单");
        AuthMap.put(User, "查看用户");
        AuthMap.put(Stat, "查看统计");
        AuthMap.put(Area, "地区查看");
        AuthMap.put(AreaNew, "创建地区");
        AuthMap.put(AreaEdit, "修改地区");
        AuthMap.put(AreaDelete, "删除地区");
    }
}
