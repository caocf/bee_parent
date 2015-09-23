package com.bee.busi.controller.order;

import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/8/19.
 */
@RestController
@RequestMapping("/busi/order")
public class BusiOrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 商家订单查询
     *
     * @param req
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<BusiOrderListItem> queryOrder(BusiOrderListRequest req) {
        return orderService.getBusiOrderListByParam(req);
    }


}
