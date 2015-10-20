package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.pojo.shop.ShopUser;
import com.bee.services.shop.IShopService;
import com.bee.services.shop.IShopUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by suntongwei on 15/10/20.
 */
@Auth
@Controller
@RequestMapping("/admin/shop/{sid}/admin")
public class AdminShopAdminController {

    @Autowired
    private IShopUserService shopUserService;
    @Autowired
    private IShopService shopService;

    /**
     * 进入商家管理员首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopAdminList");
        List<ShopUser> shopUserList = shopUserService.queryShopUserList(sid);
        mav.addObject("result", shopUserList);
        mav.addObject("sid", sid);
        if (!shopUserList.isEmpty()) {
            mav.addObject("shopName", shopUserList.get(0).getShop().getName());
        }
        return mav;
    }


    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/{shopAdminId}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long sid, @PathVariable Long shopAdminId) {
        try {
            shopUserService.deleteShopUser(shopAdminId);
            return index(sid);
        } catch (DataRunException e) {
            return index(sid).addObject("msg", "删除失败");
        }
    }


    /**
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopAdminNew");
        mav.addObject("shop", shopService.getShopById(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, AdminShopUserSaveRequest req) {
        try {
            req.setShopId(sid);
            shopUserService.saveShopUser(req);
            return index(req.getShopId());
        } catch (DataRunException e) {
            return create(sid).addObject("request", req).addObject("msg", "保存出错，请重试");
        }
    }

}
