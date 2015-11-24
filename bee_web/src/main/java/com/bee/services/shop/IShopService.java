package com.bee.services.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.modal.ShopMap;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    public List<ShopListItem> queryRecommendShop(long uid);

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
