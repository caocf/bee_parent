package com.bee.admin.controller.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.admin.services.order.IOrderService;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单监控控制器
 *
 * @since v1.0.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    /** 订单监控View */
    public static final String OrderMonitorView = "order/OrderMonitor";

    @Autowired
    private IOrderService orderService;

    /**
     * <b>监控订单</b>
     * 监控新订单
     *
     * @return OrderMonitorView
     * @version v1.0.0
     */
    @Auth(name = "ORDER_MONITOR")
    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    public ModelAndView monitor() {
        ModelAndView mav = new ModelAndView(OrderMonitorView);
        AdminOrderListRequest request = new AdminOrderListRequest();
        request.setIndexPage(0);
        request.setStatus(Consts.Order.Status.Query.New);
        PagingResult<Order> result = orderService.getOrderListByParam(request);
        if (result != null && result.getTotalData() > 0) {
            mav.addObject("result", result.getData());
        }
        return mav;
    }

}
