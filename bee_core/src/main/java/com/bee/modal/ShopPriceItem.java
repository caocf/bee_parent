package com.bee.modal;

/**
 * Created by suntongwei on 15/9/1.
 */
public class ShopPriceItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6795121131819354609L;

    private String groupName;
    private Double price;
    private String remark;

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
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
