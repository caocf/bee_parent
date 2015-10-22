package com.bee.busi.model.user;

/**
 * Created by suntongwei on 15/10/5.
 */
public class BusiShopUser implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 4404560515730624216L;

    // userId & userNick 用于环信登录
    private Long userId;
    private String userNick;
    private String phone;
    private Long shopId;
    private String shopName;
    private Integer shopStatus;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserNick() {
        return userNick;
    }
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public Integer getShopStatus() {
        return shopStatus;
    }
    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
