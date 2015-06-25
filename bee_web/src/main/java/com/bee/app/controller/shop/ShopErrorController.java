package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopError;
import com.bee.services.shop.IShopErrorService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/26.
 */
@RestController
@RequestMapping("/shop/{sid}/error")
public class ShopErrorController {

    @Autowired
    private IShopErrorService shopErrorService;

    /**
     * 
     *
     * @param sid
     * @param shopError
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse addShopError(@PathVariable Long sid, ShopError shopError) {
        BaseResponse res = new BaseResponse();
        try {
            shopError.setShop(new Shop(sid));
            shopErrorService.addShopError(shopError);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            e.printStackTrace();
        }
        return res;
    }

}
