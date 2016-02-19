package com.bee.busi.model.shop;

/**
 * Created by suntongwei on 15/10/16.
 */
public class BusiShopTechee implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2088090179479969645L;

    // 主键
    private Long stId;
    // 号码
    private String number;
    // 所属商家组
    private Long shopGroup;
    // 组名
    private String groupName;
    // 所属商家
    private Long shop;

    public Long getStId() {
        return stId;
    }
    public void setStId(Long stId) {
        this.stId = stId;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Long getShopGroup() {
        return shopGroup;
    }
    public void setShopGroup(Long shopGroup) {
        this.shopGroup = shopGroup;
    }
    public Long getShop() {
        return shop;
    }
    public void setShop(Long shop) {
        this.shop = shop;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
