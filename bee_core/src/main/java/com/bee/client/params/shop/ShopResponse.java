package com.bee.client.params.shop;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.commons.ImageFactory;
import com.bee.modal.ShopImageListItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.pojo.shop.ShopAttend;

import java.util.List;

/**
 * Created by suntongwei on 15/7/11.
 */
public class ShopResponse implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -6979109816828423070L;

    private List<ShopImageListItem> shopImages;
    private ShopItem shopListItem;
    private List<ShopAttendItem> shopAttends;

    public ShopItem getShopListItem() {
        return shopListItem;
    }
    public void setShopListItem(ShopItem shopListItem) {
        this.shopListItem = shopListItem;
    }
    public List<ShopImageListItem> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImageListItem> shopImages) {
        this.shopImages = shopImages;
    }
    public List<ShopAttendItem> getShopAttends() {
        return shopAttends;
    }
    public void setShopAttends(List<ShopAttendItem> shopAttends) {
        this.shopAttends = shopAttends;
    }
}
