package com.bee.busi.model.user;

/**
 * Created by suntongwei on 15/10/5.
 */
public class BusiShopUser implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 4404560515730624216L;

    private Long shopId;
    private String shopName;
    private Integer shopStatus;

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
}
