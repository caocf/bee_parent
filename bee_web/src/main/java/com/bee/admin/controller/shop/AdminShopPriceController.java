package com.bee.admin.controller.shop;

import com.bee.dao.shop.ShopPriceDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopPrice;
import com.bee.services.shop.IShopPriceService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/21.
 */
@Controller
@RequestMapping("/admin/shop/{sid}/price")
public class AdminShopPriceController {

    @Autowired
    private IShopPriceService shopPriceService;

    /**
     * 进入商家价格列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceList");

        return mav;
    }

    /**
     * 保存商家价格
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable long sid, ShopPrice shopPrice) {
        try {
            shopPrice.setShop(new Shop(sid));
            shopPriceService.addShopPrice(shopPrice);
            return new ModelAndView("redirect:/admin/shop");
        } catch (DataRunException e) {
            ModelAndView mav = create(sid);
            mav.addObject("msg", "保存商家价格异常");
            return mav;
        }
    }

    /**
     * 进入新增页面
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceNew");
        return mav;
    }



}
