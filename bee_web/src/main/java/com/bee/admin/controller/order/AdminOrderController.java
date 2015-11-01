package com.bee.admin.controller.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by suntongwei on 15/4/24.
 */
@Auth
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
        mav.addObject("params", request);
        return mav;
    }


    /**
     * 取消订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResponse cancel(@PathVariable Long id) {
        BaseResponse res = new BaseResponse();
        try {
            orderService.cancelOrder(id, Consts.Order.Status.CancelShop);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg("取消订单失败,请重试");
        }
        return res;
    }

    /**
     * 接受订单
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BaseResponse accept(@PathVariable Long id) {
        BaseResponse res = new BaseResponse();
        try {
            orderService.acceptOrder(id);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg("接受订单失败,请重试");
        }
        return res;
    }
}
