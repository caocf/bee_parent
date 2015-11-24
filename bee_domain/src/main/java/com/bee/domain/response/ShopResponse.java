package com.bee.domain.response;

import com.bee.domain.modal.app.shop.Shop;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopImage;
import com.qsd.framework.domain.response.Response;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
public class ShopResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -9089202824661887433L;

    private List<ShopImage> shopImages;
    private Shop shop;
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
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
