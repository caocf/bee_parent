package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.services.shop.IShopService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/4/16.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    public PagingResult queryShopList(ShopListRequest req) {
        return shopService.queryShopList(req);
    }


}
