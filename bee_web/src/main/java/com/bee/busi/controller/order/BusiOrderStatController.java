package com.bee.busi.controller.order;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.services.stat.IOrderStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/7.
 */
@RestController
@RequestMapping("/busi/order/stat")
public class BusiOrderStatController {

    @Autowired
    private IOrderStatService orderStatService;

    /**
     * 查询B端订单统计
     *
     * @return
     */
    @RequestMapping(value = "/{shopId}", method = RequestMethod.POST)
    public BusiOrderNumberStat queryOrderNumber(@PathVariable Long shopId) {
        return orderStatService.queryBusiOrderNumberStat(shopId);
    }
}
