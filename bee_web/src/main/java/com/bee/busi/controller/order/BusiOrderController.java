package com.bee.busi.controller.order;

import com.bee.client.params.order.BusiOrderListRequest;
import com.bee.services.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/8/19.
 */
@RestController
@RequestMapping("/busi/order")
public class BusiOrderController {

    @Autowired
    private IShopService shopService;

    /**
     * 商家订单查询
     *
     * @param req
     */
    @RequestMapping(method = RequestMethod.GET)
    public void queryOrder(BusiOrderListRequest req) {





    }


}
