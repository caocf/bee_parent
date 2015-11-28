package com.bee.domain.response;

import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopImage;
import com.bee.domain.modal.app.shop.ShopItem;
import com.qsd.framework.domain.response.Response;

import java.util.List;

/**
 * <b>商家详细信息</b>
 *
 * v1.0.5
 * 删除shopAttends信息
 */
public class ShopResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -9089202824661887433L;

    private List<ShopImage> shopImages;
    private ShopItem shopItem;
    @Deprecated
    private List<ShopAttend> shopAttends;

    public List<ShopImage> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImage> shopImages) {
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
    public ShopItem getShopItem() {
        return shopItem;
    }
    public void setShopItem(ShopItem shop) {
        this.shopItem = shop;
    }
}
