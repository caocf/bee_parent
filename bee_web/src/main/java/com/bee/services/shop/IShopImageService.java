package com.bee.services.shop;

import com.bee.domain.modal.app.shop.ShopImageItem;

import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
public interface IShopImageService {

    /**
     * 获取app商家图片集合
     *
     * @param sid
     * @return
     */
    public List<ShopImageItem> queryAppShopImage(long sid);

}
