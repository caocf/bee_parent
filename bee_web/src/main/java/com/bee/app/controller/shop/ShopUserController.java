package com.bee.app.controller.shop;

import com.bee.services.shop.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/9/13.
 */
@RestController
@RequestMapping("/shop/{sid}/user")
public class ShopUserController {

    @Autowired
    private IShopUserService shopUserService;




}
