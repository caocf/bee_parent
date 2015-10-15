package com.bee.busi.model.shop;


/**
 * Created by suntongwei on 15/10/15.
 */
public class BusiShopGroup implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -4768096872376924035L;

    private Long sgId;
    // 组名
    private String groupName;
    // 所属商家
    private Long shop;
    // 价格
    private Double price;
    // 价格说明
    private String remark;

    public Long getSgId() {
        return sgId;
    }
    public void setSgId(Long sgId) {
        this.sgId = sgId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Long getShop() {
        return shop;
    }
    public void setShop(Long shop) {
        this.shop = shop;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
