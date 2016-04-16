package com.bee.admin.controller.shop;

import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopGroup;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.admin.IShopGroupAdminService;
import com.bee.services.shop.admin.IShopTecheeAdminService;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 16/4/14.
 */
@Controller
@RequestMapping("/shop/{shopId}/group/{groupId}/techee")
public class ShopTecheeController {

    /** 商家技师首页 */
    public static final String ShopTecheeIndex = "shop/ShopTecheeList";
    /** 添加商家技师页面 */
    public static final String ShopTecheeNew = "shop/ShopTecheeNew";

    @Autowired
    private IShopTecheeAdminService shopTecheeAdminService;
    @Autowired
    private IShopGroupAdminService shopGroupAdminService;

    /**
     * 商家技师首页
     *
     * @param shopId
     * @param groupId
     * @return
     */
    @Auth(name = AuthName.ShopTechee)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long shopId, @PathVariable Long groupId) {
        ModelAndView mav = new ModelAndView(ShopTecheeIndex);
        mav.addObject("shopId", shopId);
        mav.addObject("groupId", groupId);
        return mav;
    }


    /**
     * 查询商家技师信息
     *
     * @param shopId
     * @param groupId
     * @return
     */
    @Auth(name = AuthName.ShopTechee)
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponseArray<ShopTechee> queryShopTecheeByGroup(@PathVariable Long shopId, @PathVariable Long groupId) {
        ResponseArray<ShopTechee> res = new ResponseArray<>();
        res.setResult(shopTecheeAdminService.queryShopTecheeByGroup(groupId));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 添加商家技师页面
     *
     * @return
     */
    @Auth(name = AuthName.ShopTecheeNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView addShopTechee(@PathVariable Long shopId, @PathVariable Long groupId) {
        ModelAndView mav = new ModelAndView(ShopTecheeNew);
        mav.addObject("shopId", shopId);
        mav.addObject("groupId", groupId);
        mav.addObject("groupName", shopGroupAdminService.getAdminShopGroupById(groupId).getGroupName());
        mav.addObject("isEdit", Consts.False);
        return mav;
    }

    /**
     * 保存商家技师
     *
     * @return
     */
    @Auth(name = AuthName.ShopTecheeNew)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Response saveShopTechee(@PathVariable Long shopId, @PathVariable Long groupId,
                                   ShopTechee shopTechee) {
        Response res = new Response();
        try {
            if (null == shopTechee.getAttend()) {
                shopTechee.setAttend(Consts.False);
            }
            shopTecheeAdminService.saveShopTechee(shopTechee);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
            res.setMsg("保存失败");
        }
        return res;
    }

    /**
     * 添加商家技师页面
     *
     * @return
     */
    @Auth(name = AuthName.ShopTecheeEdit)
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editShopTechee(@PathVariable Long shopId, @PathVariable Long groupId) {
        ModelAndView mav = new ModelAndView(ShopTecheeNew);
        mav.addObject("shopId", shopId);
        mav.addObject("groupId", groupId);
        mav.addObject("groupName", shopGroupAdminService.getAdminShopGroupById(groupId).getGroupName());
        mav.addObject("isEdit", Consts.True);
        return mav;
    }

    /**
     * 删除一个技师
     *
     * @param shopTecheeId
     * @return
     */
    @Auth(name = AuthName.ShopTecheeDelete)
    @ResponseBody
    @RequestMapping(value = "/{shopTecheeId}", method = RequestMethod.DELETE)
    public Response deleteShopTechee(@PathVariable Long shopTecheeId) {
        Response res = new Response();
        try {
            shopTecheeAdminService.deleteShopTechee(shopTecheeId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
            res.setMsg("删除失败");
        }
        return res;
    }
}
