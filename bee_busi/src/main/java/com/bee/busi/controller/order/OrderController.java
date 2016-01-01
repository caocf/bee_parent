package com.bee.busi.controller.order;

import com.bee.busi.model.order.BusiOrderItem;
import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.commons.Codes;
import com.bee.services.order.busi.IOrderBusiService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderBusiService orderBusiService;

    /**
     * 商家订单查询
     *
     * @param req
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<BusiOrderListItem> queryOrder(BusiOrderListRequest req) {
        return orderBusiService.getOrderListByParam(req);
    }

    /**
     * 商家订单详细
     *
     * @param oid 订单ID
     * @return
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public BusiOrderItem getOrder(@PathVariable Long oid) {
        return orderBusiService.getOrderItem(oid);
    }

    /**
     * 接受订单
     *
     * @return
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.PUT)
    public Response accept(@PathVariable Long oid) {
        Response res = new Response();
        try {
            orderBusiService.acceptOrder(oid);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            if (e.getErrorCode() == Codes.Order.AcceptError) {
                res.setMsg("订单状态发生改变");
            } else {
                res.setCode(Codes.Order.OrderDbError);
                res.setMsg("操作失败，请重试");
            }
        }
        return res;
    }

    /**
     * 拒绝订单
     *
     * @param oid
     * @return
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.DELETE)
    public Response reject(@PathVariable Long oid) {
        Response res = new Response();
        try {
            orderBusiService.rejectOrder(oid);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            if (e.getErrorCode() == Codes.Order.RejectError) {
                res.setMsg("订单状态发生改变");
            } else {
                res.setCode(Codes.Order.OrderDbError);
                res.setMsg("操作失败，请重试");
            }
        }
        return res;
    }

    /**
     * 完成订单
     *
     * @param oid
     * @return
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.POST)
    public Response finish(@PathVariable Long oid) {
        Response res = new Response();
        try {
            orderBusiService.finishOrder(oid);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            if (e.getErrorCode() == Codes.Order.FinishError) {
                res.setMsg("订单状态发生改变");
            } else {
                res.setCode(Codes.Order.OrderDbError);
                res.setMsg("操作失败，请重试");
            }
        }
        return res;
    }

    /**
     * 取消订单
     *
     * @param oid
     * @return
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.PATCH)
    public Response cancel(@PathVariable Long oid) {
        Response res = new Response();
        try {
            orderBusiService.cancelOrder(oid);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            if (e.getErrorCode() == Codes.Order.FinishError) {
                res.setMsg("订单状态发生改变");
            } else {
                res.setCode(Codes.Order.OrderDbError);
                res.setMsg("操作失败，请重试");
            }
        }
        return res;
    }
}
