package com.bee.admin.controller.shop;

import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.IShopGroupService;
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
 * Created by suntongwei on 15/10/20.
 */
@Auth
@Controller
@RequestMapping("/admin/shop/{sid}/group")
public class AdminShopGroupController {

    @Autowired
    private IShopGroupService shopGroupService;
    @Autowired
    private IShopService shopService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopGroupList");
        mav.addObject("result", shopGroupService.queryAdminShopGroupList(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     *
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopGroupNew");
        mav.addObject("shop", shopService.getShopById(sid));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     * 修改
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/{sgId}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long sid, @PathVariable Long sgId) {
        return create(sid).addObject("shopGroup", shopGroupService.getAdminShopGroupById(sgId));
    }


    /**
     *
     *
     * @param sid
     * @param group
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopGroup group) {
        try {
            shopGroupService.saveShopGroup(group);
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
    @RequestMapping(value = "/{sgId}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable Long sid, ShopGroup group) {
        try {
            shopGroupService.updateShopGroup(group);
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
    @RequestMapping(value = "/{sgid}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long sid, @PathVariable Long sgid) {
        try {
            shopGroupService.deleteShopGroup(sid, sgid);
            return index(sid);
        } catch (DataRunException e) {
            return index(sid).addObject("msg", "删除失败，请重试");
        }
    }




}
