package com.bee.app.controller.shop;

import com.bee.app.model.shop.ShopFocusItem;
import com.bee.app.params.shop.ShopFocusListRequest;
import com.bee.commons.Codes;
import com.bee.modal.ShopFocusFriendList;
import com.bee.services.shop.IShopFocusService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/4/19.
 */
@RestController
@RequestMapping("/shop/{sid}/focus")
public class ShopFocusController {

    @Autowired
    private IShopFocusService shopFocusService;

    /**
     * 用户关注商家
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse addShopFocus(@PathVariable Long sid, Long uid) {
        BaseResponse res = new BaseResponse();
        try {
            if (shopFocusService.getShopFocusFriend(sid, uid) != null) {
                res.setCode(Codes.Error);
                res.setMsg("您已关注该商家");
            } else {
                shopFocusService.addShopFocus(uid, sid);
                res.setCode(Codes.Success);
            }
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public List<ShopFocusFriendList> getFriendFocus(@PathVariable Long sid, @PathVariable Long uid) {
        return shopFocusService.getShopFocusFriend(sid, uid);
    }

    /**
     * 获取用户关注商户列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<ShopFocusItem> getShopFocusList(@PathVariable Long sid, ShopFocusListRequest request) {
        return shopFocusService.getShopFocusList(request);
    }

}
