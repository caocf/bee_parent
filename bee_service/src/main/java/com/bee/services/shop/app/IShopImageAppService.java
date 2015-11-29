package com.bee.services.shop.app;

import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.services.shop.IShopImageService;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopImageAppService extends IShopImageService {

    /**
     * 获取app商家图片集合
     *
     * @param sid
     * @return
     */
    List<ShopImageItem> queryShopImage(long sid);

}
