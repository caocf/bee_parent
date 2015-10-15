package com.bee.app.controller.shop;

import com.bee.modal.ShopPriceItem;
import com.bee.services.shop.IShopGroupService;
import com.bee.services.shop.IShopPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/9/1.
 */
@RestController
@RequestMapping("/shop/{sid}/price")
public class ShopPriceController {

    @Autowired
    private IShopPriceService shopPriceService;
    @Autowired
    private IShopGroupService shopGroupService;

    /**
     * 查询商家价格列表
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopPriceItem> queryShopPrice(@PathVariable Long sid) {
        return shopGroupService.queryShopPriceByShopId(sid);
    }

}
