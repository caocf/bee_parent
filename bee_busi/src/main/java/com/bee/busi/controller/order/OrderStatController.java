package com.bee.busi.controller.order;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.services.stat.busi.IOrderStatBusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/order/stat")
public class OrderStatController {

    @Autowired
    private IOrderStatBusiService orderStatBusiService;

    /**
     * 查询B端订单统计
     *
     * @return
     */
    @RequestMapping(value = "/{shopId}", method = RequestMethod.POST)
    public BusiOrderNumberStat queryOrderNumber(@PathVariable Long shopId) {
        return orderStatBusiService.queryOrderNumberStat(shopId);
    }
}
