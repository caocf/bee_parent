package com.bee.app.controller.shop;

import com.bee.domain.modal.app.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/5/31.
 */
@RestController
@RequestMapping("/shop/{sid}/image")
public class ShopImageController {

    @Autowired
    private IShopImageService shopImageService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopImage> queryShopImageList(@PathVariable Long sid) {
        return shopImageService.queryAppShopImage(sid);
    }
}
