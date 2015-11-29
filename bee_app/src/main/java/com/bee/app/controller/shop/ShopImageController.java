package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.services.shop.app.IShopImageAppService;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/20.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/image")
public class ShopImageController {

    @Autowired
    private IShopImageAppService shopImageAppService;

    /**
     * 商家图片
     *
     * @param shopId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<ShopImageItem> getShopListImage(@PathVariable Long shopId) {
        ResponseArray<ShopImageItem> res = new ResponseArray<>();
        res.setResult(shopImageAppService.queryShopImage(shopId));
        res.setCode(Codes.Success);
        return res;
    }

}
