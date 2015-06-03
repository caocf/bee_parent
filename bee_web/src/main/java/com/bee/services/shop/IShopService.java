package com.bee.services.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
public interface IShopService {

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    public PagingResult<Shop> queryShopList(AdminShopListRequest req);

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
    public List<RecommendItem> queryRecommendShop();

    /**
     * 增加商家
     *
     * @throws DataRunException
     */
    public void addShop(Shop shop) throws DataRunException;

    /**
     * 查询一个商家信息
     *
     * @param sid
     * @return
     */
    public Shop getShopById(long sid);

    /**
     * 根据ID查询商家信息
     *
     * @param sid
     * @return
     */
    public ShopItem getShopItemById(long sid);

    /**
     * 删除商家
     *
     * @param sid
     * @throws DataRunException
     */
    public void deleteShop(long sid) throws DataRunException;

    /**
     * 更新商家
     *
     * @param shop
     * @throws DataRunException
     */
    public void updateShop(Shop shop) throws DataRunException;
}
