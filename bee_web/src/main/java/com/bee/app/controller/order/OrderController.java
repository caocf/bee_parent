package com.bee.app.controller.order;

import com.bee.client.params.order.OrderCreateRequest;
import com.bee.client.params.order.OrderCreateResponse;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.modal.OrderListItem;
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
    public PagingResult<OrderListItem> index(OrderListRequest request) {
        PagingResult<OrderListItem> items = orderService.getAppOrderListByParam(request);
        items.setMaxRows(request.getMaxRows());
        return items;
    }

    /**
     * App创建订单
     */
    @RequestMapping(method = RequestMethod.POST)
    public OrderCreateResponse create(Order order) {
        OrderCreateResponse res = new OrderCreateResponse();
        try {
            orderService.createOrder(order);
            res.setOrder(order);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CreateError);
            res.setMsg("创建失败，请重试");
        }
        return res;
    }



    /**
     * 创建订单
     *
     * 2015.8.20删除该接口
     *
     * @param request
     */
//    @Deprecated
//    @RequestMapping(method = RequestMethod.POST)
//    public BaseResponse create(OrderCreateRequest request) {
//        BaseResponse res = new BaseResponse();
//        try {
//            orderService.createOrder(request);
//            res.setCode(Codes.Success);
//        } catch (DataRunException e) {
//            res.setCode(Codes.Order.CreateError);
//            res.setMsg("创建失败，请重试");
//        }
//        return res;
//    }

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
            orderService.cancelOrder(id, Consts.Order.Status.CancelUser);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg(Codes.Order.CancelErrorStr);
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
            orderService.finishOrder(id);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }
}
