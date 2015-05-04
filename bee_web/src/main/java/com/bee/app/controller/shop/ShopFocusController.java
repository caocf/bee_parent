package com.bee.app.controller.shop;

import com.bee.modal.ShopFocusFriendList;
import com.bee.services.shop.IShopFocusService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseRequest;
import com.qsd.framework.spring.BaseResponse;
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

        } catch (DataRunException e) {

        }
        return res;
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public List<ShopFocusFriendList> getFriendFocus(@PathVariable Long sid, @PathVariable Long uid) {
        return shopFocusService.getShopFocusFriend(sid, uid);
    }

}
