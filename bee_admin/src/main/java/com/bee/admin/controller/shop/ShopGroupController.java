package com.bee.admin.controller.shop;

import com.bee.commons.AuthName;
import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.admin.IShopAdminService;
import com.bee.services.shop.admin.IShopGroupAdminService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/shop/{sid}/group")
public class ShopGroupController {

    /** 商家组列表视图 */
    public static final String ShopGroupListView = "shop/ShopGroupList";
    /** 新建商家组视图 */
    public static final String ShopGroupNewView = "shop/ShopGroupNew";

    @Autowired
    private IShopGroupAdminService shopGroupAdminService;
    @Autowired
    private IShopAdminService shopAdminService;

    /**
     *
     * @return
     */
    @Auth(name = AuthName.ShopGroup)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView(ShopGroupListView);
        mav.addObject("result", shopGroupAdminService.queryAdminShopGroupList(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     *
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopGroupNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView(ShopGroupNewView);
        mav.addObject("shop", shopAdminService.getShopById(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     * 修改
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopGroupEdit)
    @RequestMapping(value = "/{sgId}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long sid, @PathVariable Long sgId) {
        return create(sid).addObject("shopGroup", shopGroupAdminService.getAdminShopGroupById(sgId));
    }


    /**
     *
     *
     * @param sid
     * @param group
     * @return
     */
    @Auth(name = AuthName.ShopGroupNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopGroup group) {
        try {
            shopGroupAdminService.saveShopGroup(group);
            return index(sid);
        } catch (DataRunException e) {
            return create(sid).addObject("msg", "创建失败，请重试");
        }
    }


    /**
     *
     * @param sid
     * @param group
     * @return
     */
    @Auth(name = AuthName.ShopGroupEdit)
    @RequestMapping(value = "/{sgId}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable Long sid, ShopGroup group) {
        try {
            shopGroupAdminService.updateShopGroup(group);
            return index(sid);
        } catch (DataRunException e) {
            return edit(sid, group.getSgId()).addObject("msg", "修改失败，请重试").addObject("shopGroup", group);
        }
    }


    /**
     *
     *
     * @param sid
     * @param sgid
     * @return
     */
    @Auth(name = AuthName.ShopGroupDelete)
    @RequestMapping(value = "/{sgid}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long sid, @PathVariable Long sgid) {
        try {
            shopGroupAdminService.deleteShopGroup(sid, sgid);
            return index(sid);
        } catch (DataRunException e) {
            return index(sid).addObject("msg", "删除失败，请重试");
        }
    }

}
