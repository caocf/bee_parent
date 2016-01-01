package com.bee.app.controller.order;

import com.bee.app.commons.AppConsts;
import com.bee.client.params.order.OrderCreateResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.bee.pojo.order.Order;
import com.bee.services.order.app.IOrderAppService;
import com.bee.sms.SMSUtils;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseObject;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/25.
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private IOrderAppService orderAppService;


    /**
     * App创建订单
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseObject<Order> create(Order order) {
        ResponseObject<Order> res = new ResponseObject<>();
        // 对参数进行校验
        if (StringUtil.checkIllegalChar(order.getRemark(),
                order.getOrderName(), order.getOrderPhone(), order.getDevice())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容包含非法字符");
            return res;
        }
        try {
            // 保存新订单
            orderAppService.createOrder(order);
            res.setResult(order);
            res.setCode(Codes.Success);

            // 发送短信
            if (!AppConsts.isDebug) {
                SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.Order, Consts.Config.ServicePhone,
                        order.getShop().getName() + "," + order.getShopUser().getPhone() + "(" +
                                order.getShopUser().getName() + ")", order.getNum().toString(), order.getOrderPhone());
            }

        } catch (DataRunException e) {
            res.setCode(Codes.Order.CreateError);
            res.setMsg("创建失败，请重试");
        }
        return res;
    }

    /**
     * 查询订单列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<OrderListItem> index(OrderListParam param) {
        ResponsePaging<OrderListItem> res = new ResponsePaging<>();
        PagingResult<OrderListItem> items = orderAppService.getAppOrderListByParam(param);
        items.setMaxRows(param.getMaxRows());
        res.setResult(items);
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 查询订单信息
     * 主要用于查看订单时，实时更新订单状态等订单信息
     *
     * @return oid 订单ID
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public ResponseObject<OrderItem> queryOrder(@PathVariable Long oid) {
        ResponseObject res = new ResponseObject();
        res.setResult(orderAppService.queryOrderItemById(oid));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 修改订单人数
     *
     * @param oid 订单ID
     * @param num 新人数
     * @return
     */
    @RequestMapping(value = "/{oid}/edit/num", method = RequestMethod.PATCH)
    public Response editOrderNum(@PathVariable Long oid, Integer num) {
        Response res = new Response();
        try {
            orderAppService.changeOrderNum(oid, num);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            if (e.getErrorCode() == Codes.Order.EditError) {
                res.setMsg("订单状态发生改变");
            } else if (e.getErrorCode() == Codes.Order.EditNoChangeError) {
                res.setMsg("订单人数未改变");
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
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response cancel(@PathVariable Long id) {
        Response res = new Response();
        try {
            orderAppService.cancelOrder(id);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg(Codes.Order.CancelErrorStr);
        }
        return res;
    }
}
