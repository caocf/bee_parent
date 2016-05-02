package com.bee.domain.response;

import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.pojo.shop.ShopConfig;
import com.qsd.framework.domain.response.Response;

import java.util.List;

/**
 * <b>商家详细信息</b>
 *
 * v1.0.5
 * 删除shopAttends信息
 */
@Deprecated
public class ShopResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -9089202824661887433L;

    private List<ShopImageItem> shopImages;
    private ShopItem shopItem;
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
    public ShopItem getShopItem() {
        return shopItem;
    }
    public void setShopItem(ShopItem shop) {
        this.shopItem = shop;
    }
}
