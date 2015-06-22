package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
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
    public ShopListItem getShopItem(@PathVariable Long id) {
        return shopService.getShopItemById(id);
    }
}
