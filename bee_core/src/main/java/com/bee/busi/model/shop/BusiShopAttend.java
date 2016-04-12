package com.bee.busi.model.shop;

/**
 * Created by suntongwei on 15/10/8.
 */
public class BusiShopAttend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7886562853570802808L;
    // 主键
    private Long saId;
    // 技师
    private Long shopTechee;
    // 出勤时间
    private Long attendTime;
    // 所属商家
    private Long shop;

    public Long getSaId() {
        return saId;
    }
    public void setSaId(Long saId) {
        this.saId = saId;
    }
    public Long getShopTechee() {
        return shopTechee;
    }
    public void setShopTechee(Long shopTechee) {
        this.shopTechee = shopTechee;
    }
    public Long getAttendTime() {
        return attendTime;
    }
    public void setAttendTime(Long attendTime) {
        this.attendTime = attendTime;
    }
    public Long getShop() {
        return shop;
    }
    public void setShop(Long shop) {
        this.shop = shop;
    }
}
