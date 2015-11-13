package com.bee.admin.services.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by suntongwei on 15/11/8.
 */
public interface IShopService {

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    PagingResult<Shop> queryShopList(AdminShopListRequest req);

    /**
     * 查询一个商家信息
     *
     * @param sid
     * @return
     */
    Shop getShopById(long sid);

    /**
     * 增加商家
     *
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void addShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException;


    /**
     *【A端】删除商家
     *
     * @param sid
     * @throws DataRunException
     */
    void deleteShop(long sid) throws DataRunException;

    /**
     * 更新商家
     *
     * @param shop
     * @throws DataRunException
     */
    public void updateShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException;
}
