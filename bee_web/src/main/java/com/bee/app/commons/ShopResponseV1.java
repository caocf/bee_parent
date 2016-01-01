package com.bee.app.commons;

import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.domain.modal.app.shop.ShopItem;

import java.util.List;

/**
 * 为了兼容v1.0.4版本
 *
 * Created by suntongwei on 15/12/11.
 */
public class ShopResponseV1 implements java.io.Serializable {

    private static final long serialVersionUID = 1065198285760117514L;

    private List<ShopImageItem> shopImages;
    private ShopItem shopListItem;
    @Deprecated
    private List<ShopAttend> shopAttends;

    public List<ShopImageItem> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImageItem> shopImages) {
        this.shopImages = shopImages;
    }
    @Deprecated
    public List<ShopAttend> getShopAttends() {
        return shopAttends;
    }
    @Deprecated
    public void setShopAttends(List<ShopAttend> shopAttends) {
        this.shopAttends = shopAttends;
    }
    public ShopItem getShopListItem() {
        return shopListItem;
    }
    public void setShopListItem(ShopItem shop) {
        this.shopListItem = shop;
    }
}
