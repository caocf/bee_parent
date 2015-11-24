package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopSaveRequest;
import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.commons.AuthName;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.admin.IShopAdminService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商家信息控制器
 *
 * @since v1.0.0
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private IShopAdminService shopService;

    /**
     * 商家列表
     *
     * @return
     */
    @Auth(name = AuthName.Shop)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView shopListView(AdminShopListRequest req) {
        ModelAndView mav = new ModelAndView("shop/ShopList");
        mav.addObject("result", shopService.queryShopList(req));
        mav.addObject("params", req);
        return mav;
    }

    /**
     * 查询商家列表信息，ShopSelectDialog
     *
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public PagingResult<Shop> queryShopList(AdminShopListRequest req) {
        return shopService.queryShopList(req);
    }


    /**
     * 查看商家详细
     *
     * @param id
     * @return
     */
    @Auth(name = AuthName.Shop)
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
    @Auth(name = AuthName.ShopNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(AdminShopSaveRequest req, MultipartHttpServletRequest request) {
        ModelAndView mav;
        try {
            if (!StringUtil.isNull(req.getSortTimeText())) {
                req.getShop().setSortTime(DateUtil.parseDateLong(req.getSortTimeText(), DateUtil.DATE));
            } else {
                req.getShop().setSortTime(0l);
            }
            req.getShop().setServiceTime(
                    req.getStartServiceTimeHour() + ":" + req.getStartServiceTimeMinute() +
                            "-" + req.getEndServiceTimeHour() + ":" + req.getEndServiceTimeMinute());
            shopService.addShop(req.getShop(), request);
            AdminShopListRequest adminShopListRequest = new AdminShopListRequest();
            adminShopListRequest.setIndexPage(1);
            mav = shopListView(adminShopListRequest);
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
    @Auth(name = AuthName.ShopNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("shop/ShopNew").addObject("action","new");
    }

    /**
     * 删除商家
     *
     * @return
     */
    @Auth(name = AuthName.ShopDelete)
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
    @Auth(name = AuthName.ShopEdit)
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
    @Auth(name = AuthName.ShopEdit)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable Long id, AdminShopSaveRequest req, MultipartHttpServletRequest request) {
        try {
            if (!StringUtil.isNull(req.getSortTimeText())) {
                req.getShop().setSortTime(DateUtil.parseDateLong(req.getSortTimeText(), DateUtil.DATE));
            } else {
                req.getShop().setSortTime(0l);
            }
            req.getShop().setServiceTime(
                    req.getStartServiceTimeHour() + ":" + req.getStartServiceTimeMinute() +
                            "-" + req.getEndServiceTimeHour() + ":" + req.getEndServiceTimeMinute());
            shopService.updateShop(req.getShop(), request);
            return shopListView(new AdminShopListRequest());
        } catch (DataRunException e) {
            return edit(id).addObject("msg", "更新失败");
        }
    }
}
