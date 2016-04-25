package com.bee.admin.controller.order;

import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.order.AdminOrderParam;
import com.bee.pojo.order.Order;
import com.bee.services.order.admin.IOrderAdminService;
import com.bee.services.ticket.admin.IUserTicketAdminService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 订单监控控制器
 *
 * @since v1.0.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    /** 订单监控 */
    public static final String OrderMonitorView = "order/OrderMonitor";
    /** 订单查询 */
    public static final String OrderView = "order/OrderList";
    /** 订单详细 */
    public static final String OrderDetail = "order/OrderDetail";

    @Autowired
    private IOrderAdminService orderService;
    @Autowired
    private IUserTicketAdminService userTicketAdminService;

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
        AdminOrderParam request = new AdminOrderParam();
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
    public ModelAndView index(AdminOrderParam request) {
        ModelAndView mav = new ModelAndView(OrderView);
        mav.addObject("result", orderService.getOrderListByParam(request));
        mav.addObject("params", request);
        return mav;
    }

    /**
     * 查询订单列表
     *
     * @return
     */
    @Auth(name = AuthName.Order)
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<Order> queryOrderList(AdminOrderParam param) {
        ResponsePaging<Order> res = new ResponsePaging<>();
        res.setResult(orderService.getOrderListByParam(param));
        res.setCode(Codes.Success);
        return res;
    }


    /**
     * 查看订单详细
     *
     * @return
     */
    @Auth(name = AuthName.Order)
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable Long orderId) {
        ModelAndView mav = new ModelAndView(OrderDetail);
        // 查询订单基本信息
        mav.addObject("order", orderService.getOrderDetailByOid(orderId));
        // 查询用户是否使用优惠券
        mav.addObject("ticket", userTicketAdminService.getUserTicketByOrder(orderId));
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
     * 接受订单
     *
     * @return
     */
    @Auth(name = AuthName.OrderAccept)
    @ResponseBody
    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    public Response accept(@PathVariable Long orderId) {
        Response res = new Response();
        try {
            orderService.acceptOrder(orderId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            if (e.getErrorCode() == Codes.Order.AcceptError) {
                res.setCode(Codes.Order.AcceptError);
                res.setMsg("接受失败,订单状态已经改变");
            } else {
                res.setCode(Codes.Error);
                res.setMsg("操作失败");
            }
        }
        return res;
    }

    /**
     * 完成订单
     *
     * @param orderId
     * @return
     */
    @Auth(name = AuthName.OrderFinish)
    @ResponseBody
    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    public Response finish(@PathVariable Long orderId) {
        Response res = new Response();
        try {
            orderService.finishOrder(orderId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            if (e.getErrorCode() == Codes.Order.FinishError) {
                res.setCode(Codes.Order.FinishError);
                res.setMsg("操作失败,订单状态已经改变");
            } else {
                res.setCode(Codes.Error);
                res.setMsg("操作失败");
            }
        }
        return res;
    }

    /**
     * 订单取消功能
     *
     * @return
     */
    @Auth(name = AuthName.OrderDelete)
    @ResponseBody
    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public Response cancel(@PathVariable Long orderId) {
        Response res = new Response();
        try {
            orderService.cancelOrder(orderId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败");
        }
        return res;
    }


    /**
     * 修改订单人数
     *
     * @param orderId 订单ID
     * @param num 新人数
     * @return
     */
    @Auth(name = AuthName.OrderFinish)
    @ResponseBody
    @RequestMapping(value = "/{orderId}/edit/num", method = RequestMethod.PATCH)
    public Response editOrderNum(@PathVariable Long orderId, Integer num) {
        Response res = new Response();
        try {
            orderService.changeOrderNum(orderId, num);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            if (e.getErrorCode() == Codes.Order.EditError) {
                res.setCode(Codes.Order.EditError);
                res.setMsg("订单状态发生改变");
            } else if (e.getErrorCode() == Codes.Order.EditNoChangeError) {
                res.setCode(Codes.Order.EditNoChangeError);
                res.setMsg("订单人数未改变");
            } else {
                res.setCode(Codes.Order.OrderDbError);
                res.setMsg("操作失败，请重试");
            }
        }
        return res;
    }

}
