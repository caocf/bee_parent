package com.bee.client.params.shop;

import com.bee.commons.ImageFactory;
import com.bee.modal.ShopImageListItem;
import com.bee.modal.ShopListItem;

import java.util.List;

/**
 * Created by suntongwei on 15/7/11.
 */
public class ShopResponse implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -6979109816828423070L;

    private List<ShopImageListItem> shopImages;
    private ShopListItem shopListItem;

    public ShopListItem getShopListItem() {
        return shopListItem;
    }
    public void setShopListItem(ShopListItem shopListItem) {
        this.shopListItem = shopListItem;
    }
    public List<ShopImageListItem> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImageListItem> shopImages) {
        this.shopImages = shopImages;
    }
}
