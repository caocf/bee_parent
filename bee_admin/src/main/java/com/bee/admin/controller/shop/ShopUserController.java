package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.admin.services.shop.IShopService;
import com.bee.admin.services.shop.IShopUserService;
import com.bee.commons.AuthName;
import com.bee.pojo.shop.ShopUser;
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
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/shop/{sid}/admin")
public class ShopUserController {

    @Autowired
    private IShopUserService shopUserService;
    @Autowired
    private IShopService shopService;

    /**
     * 进入商家管理员首页
     *
     * @return
     */
    @Auth(name = AuthName.ShopUser)
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
    @Auth(name = AuthName.ShopUserDelete)
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
    @Auth(name = AuthName.ShopUserNew)
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
    @Auth(name = AuthName.ShopUserNew)
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
