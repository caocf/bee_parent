package com.bee.admin.controller.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView shopListView(AdminShopListRequest req) {
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
    public ModelAndView save(Shop shop, String sortTimeText, MultipartHttpServletRequest req) {
        ModelAndView mav;
        try {
            if (!StringUtil.isNull(sortTimeText)) {
                shop.setSortTime(DateUtil.parseDateLong(sortTimeText, DateUtil.DATE));
            }
            shopService.addShop(shop, req);
            AdminShopListRequest request = new AdminShopListRequest();
            request.setIndexPage(1);
            mav = shopListView(request);
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
        return new ModelAndView("shop/ShopNew").addObject("action","new");
    }

    /**
     * 删除商家
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long id) {
        try {
            shopService.deleteShop(id);
        } catch(DataRunException e) {
        }
        return shopListView(new AdminShopListRequest());
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("shop/ShopNew");
        mav.addObject("shop", shopService.getShopById(id));
        mav.addObject("action", "edit");
        return mav;
    }

    /**
     * 更新商家
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable Long id, Shop shop, String sortTimeText, MultipartHttpServletRequest req) {
        try {
            if (!StringUtil.isNull(sortTimeText)) {
                shop.setSortTime(DateUtil.parseDateLong(sortTimeText, DateUtil.DATE));
            }
            shopService.updateShop(shop, req);
            return shopListView(new AdminShopListRequest());
        } catch (DataRunException e) {
            return edit(id).addObject("msg", "更新失败");
        }
    }

}
