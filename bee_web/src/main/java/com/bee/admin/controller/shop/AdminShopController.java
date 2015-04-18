package com.bee.admin.controller.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.services.shop.IShopService;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/18.
 */
@Auth
@Controller
@RequestMapping("/admin/shop")
public class AdminShopController {

    @Autowired
    private IShopService shopService;

    /**
     * 商家列表
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView shopListView(ShopListRequest req) {
        ModelAndView mav = new ModelAndView("shop/ShopList");
        mav.addObject("result", shopService.queryShopList(req));
        return mav;
    }

}
