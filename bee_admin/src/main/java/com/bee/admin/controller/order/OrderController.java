package com.bee.admin.controller.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.AuthName;
import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.services.order.admin.IOrderAdminService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    /** 订单查询View */
    public static final String OrderView = "order/OrderList";

    @Autowired
    private IOrderAdminService orderService;

    /**
     * <b>监控订单</b>
     * 监控新订单
     *
     * @return OrderMonitorView
     * @since v1.0.0
     */
    @Auth(name = AuthName.OrderMonitor)
    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    public ModelAndView monitor() {
        ModelAndView mav = new ModelAndView(OrderMonitorView);
        AdminOrderListRequest request = new AdminOrderListRequest();
        request.setIndexPage(0);
        request.setStatus(Consts.Order.Status.Query.Finish);
        PagingResult<Order> result = orderService.getOrderListByParam(request);
        if (result != null && result.getTotalData() > 0) {
            mav.addObject("result", result.getData());
        }
        return mav;
    }

    /**
     * 进入订单列表
     *
     * @return
     * @since v1.0.0
     */
    @Auth(name = AuthName.Order)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(AdminOrderListRequest request) {
        ModelAndView mav = new ModelAndView(OrderView);
        mav.addObject("result", orderService.getOrderListByParam(request));
        mav.addObject("params", request);
        return mav;
    }

    /**
     * 创建订单
     *
     * @return
     */
    @Auth(name = AuthName.OrderCreate)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createSystemOrder() {
        return null;
    }


    /**
     * 订单取消功能
     *
     * @return
     */
    @Auth(name = AuthName.OrderDelete)
    @RequestMapping(value = "/{oid}", method = RequestMethod.DELETE)
    public ModelAndView cancel(@PathVariable Long oid) {
        ModelAndView mav;
        try {
            orderService.cancelOrder(oid);
            mav = index(new AdminOrderListRequest());
        } catch (DataRunException e) {
            mav = index(new AdminOrderListRequest());
            mav.addObject("msg", "删除失败");
        }
        return mav;
    }

}
