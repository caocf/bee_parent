package com.bee.app.controller.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/4/19.
 */
@RestController
@RequestMapping("/shop/{sid}/focus")
public class ShopFocusController {

    @RequestMapping(method = RequestMethod.POST)
    public void addShop() {

    }

}
