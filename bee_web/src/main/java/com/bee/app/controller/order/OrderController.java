package com.bee.app.controller.order;

import com.bee.app.model.order.OrderItem;
import com.bee.client.params.order.OrderCreateResponse;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.modal.OrderListItem;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.bee.services.order.IOrderService;
import com.bee.sms.SMSUtils;
import com.qsd.framework.commons.utils.StringUtil;
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
     * 查询订单信息
     * 主要用于查看订单时，实时更新订单状态等订单信息
     *
     * @return oid 订单ID
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public OrderItem queryOrder(@PathVariable Long oid) {
        return orderService.getOrderByOid(oid);
    }

    /**
     * App创建订单
     */
    @RequestMapping(method = RequestMethod.POST)
    public OrderCreateResponse create(Order order) {
        OrderCreateResponse res = new OrderCreateResponse();
        // 对参数进行校验
        if (StringUtil.checkIllegalChar(order.getRemark(),
                order.getOrderName(), order.getOrderPhone(), order.getDevice())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容包含非法字符");
            return res;
        }
        // 除了APP用户和VIP用户，都无法下单
        if (order.getUser() != null) {
            if (order.getUser().getType() != Consts.User.Type.AppUser
                    || order.getUser().getType() != Consts.User.Type.VipUser) {
                res.setCode(Codes.Error);
                res.setMsg("该帐号无法下单");
                return res;
            }
        }
        try {
            orderService.createOrder(order);
            res.setOrder(order);
            res.setCode(Codes.Success);

            // 发送短信
            SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.Order, Consts.Config.ServicePhone,
                    order.getShop().getName() + "," + order.getShopUser().getPhone() + "(" +
                    order.getShopUser().getName() + ")", order.getNum().toString(), order.getOrderPhone());

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
            orderService.cancelOrder(id, Consts.Order.Status.CancelUser);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Order.CancelError);
            res.setMsg(Codes.Order.CancelErrorStr);
        }
        return res;
    }

//    /**
//     * 完成订单
//     *
//     * @return
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public BaseResponse finish(@PathVariable Long id) {
//        BaseResponse res = new BaseResponse();
//        try {
//            orderService.finishOrder(id);
//            res.setCode(Codes.Success);
//        } catch(DataRunException e) {
//            e.printStackTrace();
//            res.setCode(Codes.Error);
//        }
//        return res;
//    }

    /**
     * 修改订单人数
     *
     * @param oid 订单ID
     * @param num 新人数
     * @return
     */
    @RequestMapping(value = "/{oid}/edit/num", method = RequestMethod.PATCH)
    public BaseResponse editOrderNum(@PathVariable Long oid, Integer num) {
        BaseResponse res = new BaseResponse();
        try {
            orderService.editOrderNum(oid, num);
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
}
