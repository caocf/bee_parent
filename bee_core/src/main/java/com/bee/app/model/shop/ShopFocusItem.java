package com.bee.app.model.shop;

/**
 * Created by suntongwei on 15/10/13.
 */
public class ShopFocusItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8480604747751914359L;

    private Long shopId;
    private String name;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
