package com.bee.admin.controller.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView shopListView(ShopListRequest req) {
        ModelAndView mav = new ModelAndView("shop/ShopList");
        mav.addObject("result", shopService.queryShopList(req));
        mav.addObject("params", req);
        return mav;
    }

    /**
     * 查看商家详细
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("shop/ShopView");
        mav.addObject("shop", shopService.getShopById(id));
        return mav;
    }

    /**
     * 保存商家
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Shop shop) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceNew");
        try {
            shopService.addShop(shop);
            mav.addObject("sid", shop.getSid());
            mav.addObject("name", shop.getName());
            mav.addObject("isRegShop", Consts.True);
        } catch(DataRunException e) {
            mav = create();
            mav.addObject("msg", "添加商家出错");
        }
        return mav;
    }

    /**
     * 进入创建商家页面
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("shop/ShopNew");
        return mav;
    }

}
