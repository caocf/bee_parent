package com.bee.domain.response;

import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopImage;
import com.bee.domain.modal.app.shop.ShopItem;
import com.qsd.framework.domain.response.Response;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
public class ShopResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -9089202824661887433L;

    private List<ShopImage> shopImages;
    private ShopItem shopItem;
    private List<ShopAttend> shopAttends;


    public List<ShopImage> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImage> shopImages) {
        this.shopImages = shopImages;
    }
    public List<ShopAttend> getShopAttends() {
        return shopAttends;
    }
    public void setShopAttends(List<ShopAttend> shopAttends) {
        this.shopAttends = shopAttends;
    }
    public ShopItem getShopItem() {
        return shopItem;
    }
    public void setShopItem(ShopItem shop) {
        this.shopItem = shop;
    }
}
