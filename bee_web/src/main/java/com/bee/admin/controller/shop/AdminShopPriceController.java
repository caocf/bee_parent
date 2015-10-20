package com.bee.admin.controller.shop;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopPrice;
import com.bee.services.shop.IShopPriceService;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/21.
 */
@Deprecated
@Controller
@RequestMapping("/admin/shop/{sid}/price")
public class AdminShopPriceController {

    // Log
    private final Logger Log = LoggerFactory.getLogger(AdminShopPriceController.class);

    @Autowired
    private IShopService shopService;
    @Autowired
    private IShopPriceService shopPriceService;

    /**
     * 进入商家价格列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceList");
        mav.addObject("shop", shopService.getShopById(sid));
        mav.addObject("result", shopPriceService.queryShopPriceByShopId(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     * 保存商家价格
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopPrice shopPrice, Integer isRegShop) {
        try {
            shopPrice.setShop(new Shop(sid));
            shopPriceService.addShopPrice(shopPrice);
            if(isRegShop != null) {
                return new ModelAndView("redirect:/admin/shop");
            } else {
                return index(sid);
            }
        } catch (DataRunException e) {
            Log.error("error: ShopPrice save exception.", e);
            ModelAndView mav = create(sid, isRegShop);
            mav.addObject("result", shopPrice);
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
    public ModelAndView create(@PathVariable Long sid, Integer isRegShop) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceNew");
        mav.addObject("shop", shopService.getShopById(sid));
        mav.addObject("sid", sid);
        mav.addObject("isRegShop", isRegShop);
        return mav;
    }

    /**
     * 进去修改页面
     *
     * @param sid
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long sid, @PathVariable Long id) {
        ModelAndView mav = new ModelAndView("shop/ShopPriceNew");
        mav.addObject("shop", shopService.getShopById(sid));
        mav.addObject("sid", sid);
        mav.addObject("result", shopPriceService.getShopPriceById(id));
        return mav;
    }

    /**
     * 修改
     *
     * @param sid
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable Long sid, @PathVariable Long id, ShopPrice shopPrice) {
        try {
            shopPriceService.updateShopPrice(shopPrice);
            return index(sid);
        } catch (DataRunException e) {
            return edit(sid, id).addObject("msg", "修改商家价格失败");
        }
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long sid, @PathVariable Long id) {
        try {
            shopPriceService.deleteShopPrice(id);
            return index(sid);
        } catch(DataRunException e) {
            return index(sid).addObject("msg", "删除商家价格失败");
        }
    }

}
