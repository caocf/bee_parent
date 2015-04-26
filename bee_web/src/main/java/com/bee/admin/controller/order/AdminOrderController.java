package com.bee.admin.controller.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/24.
 */
@Controller
@RequestMapping(value = "/admin/order")
public class AdminOrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 进入订单列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(AdminOrderListRequest request) {
        ModelAndView mav = new ModelAndView("order/OrderList");
        mav.addObject("result", orderService.getOrderListByParam(request));
        return mav;
    }


}
