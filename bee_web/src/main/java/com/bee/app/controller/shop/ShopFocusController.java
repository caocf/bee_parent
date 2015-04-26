package com.bee.app.controller.shop;

import com.qsd.framework.spring.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/4/19.
 */
@RestController
@RequestMapping("/shop/{sid}/focus")
public class ShopFocusController {

    /**
     * 用户关注商家
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse addShop(@PathVariable Long sid) {
        BaseResponse res = new BaseResponse();
        return res;
    }

}
