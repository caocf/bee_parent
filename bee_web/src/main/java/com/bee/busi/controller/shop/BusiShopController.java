package com.bee.busi.controller.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/8/19.
 */
@RestController
@RequestMapping("/busi/shop")
public class BusiShopController {

    @RequestMapping(value = "/{sid}", method = RequestMethod.POST)
    public void updateShop() {

    }


}
