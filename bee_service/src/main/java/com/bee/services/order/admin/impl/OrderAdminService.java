package com.bee.services.order.admin.impl;

import com.bee.commons.*;
import com.bee.dao.user.UserDao;
import com.bee.domain.params.order.AdminOrderParam;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.bee.services.order.admin.IOrderAdminService;
import com.bee.services.order.impl.OrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class OrderAdminService extends OrderService implements IOrderAdminService {

    /**
     * 根据参数查询订单列表
     *
     * @param request
     * @return
     */
    @Override
    @Deprecated
    public PagingResult<Order> getOrderListByParam(AdminOrderParam request) {
        return orderDao.getOrderListByParam(request);
    }

    /**
     * 查询订单详细
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getOrderDetailByOid(Long orderId) {
        return orderDao.getOrderDetail(orderId);
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
     * 接受订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void acceptOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        if (order.getStatus() != Consts.Order.Status.Create) {
            throw new DataRunException(Codes.Order.AcceptError);
        }
        order.setStatus(Consts.Order.Status.Underway);
        order.writeOperate("管理员接受订单");
        orderDao.update(order);
    }

    /**
     * 完成订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void finishOrder(long id) throws DataRunException {
        // 设置完成订单
        Order order = orderDao.findById(id);
        if (order.getStatus() != Consts.Order.Status.Underway) {
            throw new DataRunException(Codes.Order.FinishError);
        }
        order.setFinishTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.Finish);
        order.writeOperate("管理员完成订单");
        orderDao.update(order);
        // 完成订单后,调整用户信息
        finishOrderUpdateIntegral(order.getUser());
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

    /**
     * 修改订单人数
     *
     * @param oid
     * @param num
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void changeOrderNum(long oid, int num) throws DataRunException {
        Order order = orderDao.findById(oid);
        // 判断订单是否可以被修改
        if (!OrderStatusMachine.isEditOrderNum(order.getStatus())) {
            throw new DataRunException(Codes.Order.EditError);
        }
        if (null == order.getNum() || num < 1 || num == order.getNum()) {
            throw new DataRunException(Codes.Order.EditNoChangeError);
        }
        order.setNum(num);
        order.writeOperate("管理员修改了订单人数为" + num);
        orderDao.update(order);
    }
}
