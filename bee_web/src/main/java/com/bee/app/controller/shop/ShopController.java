package com.bee.app.controller.shop;

import com.bee.app.commons.ShopResponseV1;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.domain.response.ShopResponse;
import com.bee.modal.ShopMap;
import com.bee.services.shop.IShopAttendService;
import com.bee.services.shop.IShopImageService;
import com.bee.services.shop.IShopService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IShopImageService shopImageService;
    @Autowired
    private IShopAttendService shopAttendService;

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<ShopListItem> queryShopList(ShopListRequest req) {
        return shopService.queryAppShopList(req);
    }

    /**
     * 查询推荐商家
     *
     * @return
     */
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public List<ShopListItem> queryRecommendShop(Long uid) {
        return shopService.queryRecommendShop(uid);
    }

    /**
     * 查询商家
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShopResponseV1 getShopItem(@PathVariable Long id) {

        // ShopResponse
        ShopResponseV1 res = new ShopResponseV1();

        /**
         * 增加商家浏览统计
         */


        /**
         * 获取商家信息
         */
        res.setShopListItem(shopService.getShopItemById(id));

        /**
         * 获取商家滚动相册
         */
        res.setShopImages(shopImageService.queryAppShopImage(id));

        /**
         * 加入商家出勤表
         */
        res.setShopAttends(shopAttendService.getAppShopAttendByShopId(id));

        return res;
    }

    /**
     * 返回所有商家地图
     *
     * @return
     */
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public List<ShopMap> queryShopMap() {
        return shopService.queryShopMapAll();
    }
}
