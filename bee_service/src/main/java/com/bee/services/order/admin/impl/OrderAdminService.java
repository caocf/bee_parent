package com.bee.services.order.admin.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.commons.OrderStatusMachine;
import com.bee.pojo.order.Order;
import com.bee.services.order.admin.IOrderAdminService;
import com.bee.services.order.impl.OrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class OrderAdminService extends OrderService implements IOrderAdminService {

    /**
     *
     * @param request
     * @return
     */
    @Override
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        return orderDao.getOrderListByParam(request);
    }

    /**
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getOrder(Long orderId) {
        return null;
    }

    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void createOrder(Order order) throws DataRunException {
        // nothing
    }

    /**
     * 取消订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void cancelOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        // 判断订单是否可以取消
        if (!OrderStatusMachine.isCancelOrder(order.getStatus())) {
            throw new DataRunException(Codes.Order.CancelError, Codes.Order.CancelErrorStr);
        }
        order.setFinishTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.CancelAdmin);
        order.writeOperate(Consts.Order.Operate.AdminCancel);
        orderDao.update(order);
        // 判断订单是否使用红包
        if (order.getUser() != null && order.getUser().getUid() > 0) {
            cancelOrderAndTicket(order.getUser().getUid(), order.getOid());
        }
        // 减去用户响应诚信积分
        // 待实现
    }


    @Override
    @Transactional
    public void changeOrderNum(long oid, int num) throws DataRunException {

    }
}
