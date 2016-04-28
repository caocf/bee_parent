package com.bee.services.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.modal.ShopMap;
import com.qsd.framework.spring.PagingResult;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
public interface IShopService {

    /**
     * 查询APP商家列表
     *
     * @param req
     * @return
     */
    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest req);

    /**
     * 查询APP推荐商家
     *
     * @return
     */
    public List<ShopListItem> queryRecommendShop();

    /**
     * 根据ID查询商家信息
     *
     * @param sid
     * @return
     */
    public ShopItem getShopItemById(long sid);

    /**
     * 查询全部商家地图
     *
     * @return
     */
    public List<ShopMap> queryShopMapAll();

}
