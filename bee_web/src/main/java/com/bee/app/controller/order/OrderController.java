package com.bee.app.controller.order;

import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/4/24.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    // Log
    private final Logger Log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;

    /**
     * 查询订单列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Order> index(OrderListRequest request) {

        return null;
    }

    /**
     * 创建订单
     *
     * @param order
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse create(Order order) {
        BaseResponse res = new BaseResponse();
        try {
            orderService.createOrder(order);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CreateError);
            res.setMsg("创建失败，请重试");
        }
        return res;
    }

    /**
     * 取消订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResponse cancel(@PathVariable Long id) {
        BaseResponse res = new BaseResponse();
        try {
            orderService.cancelOrder(id, Consts.Order.Status.Cancel);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg("取消失败，请重试");
        }
        return res;
    }

    /**
     * 完成订单
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BaseResponse finish(@PathVariable Long id) {
        BaseResponse res = new BaseResponse();
        try {

        } catch(DataRunException e) {

        }
        return res;
    }
}
