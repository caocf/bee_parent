package com.bee.services.order.busi.impl;

import com.bee.busi.model.order.BusiOrderItem;
import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.commons.*;
import com.bee.dao.user.UserDao;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.bee.services.order.busi.IOrderBusiService;
import com.bee.services.order.impl.OrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class OrderBusiService extends OrderService implements IOrderBusiService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据参数查询商户端订单列表
     *
     * @param request
     * @return
     */
    @Override
    public List<BusiOrderListItem> getOrderListByParam(BusiOrderListRequest request) {
        return orderDao.getBusiOrderListByParam(request);
    }

    /**
     * 根据订单ID查询商户端订单详细
     *
     * @return
     */
    @Override
    public BusiOrderItem getOrderItem(long oid) {
        return orderDao.getBusiOrderItem(oid);
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
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void acceptOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        if (order.getStatus() != Consts.Order.Status.Create) {
            throw new DataRunException(Codes.Order.AcceptError);
        }
        order.setStatus(Consts.Order.Status.Underway);
        order.writeOperate(Consts.Order.Operate.Underway);
        orderDao.update(order);
    }

    /**
     * 【B端】商家拒绝订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void rejectOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        if (!OrderStatusMachine.isRejectOrder(order.getStatus())) {
            throw new DataRunException(Codes.Order.RejectError);
        }
        order.setFinishTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.ShopReject);
        order.writeOperate(Consts.Order.Operate.ShopReject);
        orderDao.update(order);
    }

    /**
     * 【B端】完成订单
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
        order.writeOperate(Consts.Order.Operate.Finish);
        orderDao.update(order);

        // 增加用户积分
        // 先判断是否是注册用户
        User user = order.getUser();
        if (user != null && user.getUid() > 0) {
            user.addIntegral(IntegralMachine.OrderFinish);
            user.addExp(LevelMachine.OrderFinish);
            userDao.update(user);
        }
    }

    /**
     * 【B端】商户取消订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void cancelOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        // 判断订单是否可以取消
        if (!OrderStatusMachine.isCancelBusiOrder(order.getStatus())) {
            throw new DataRunException(Codes.Order.CancelError, Codes.Order.CancelErrorStr);
        }
        order.setFinishTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.CancelShop);
        order.writeOperate(Consts.Order.Operate.ShopCancel);
        orderDao.update(order);
    }

    /**
     * B端不实现修改人数
     *
     * @param oid
     * @param num
     * @throws DataRunException
     */
    @Override
    public void changeOrderNum(long oid, int num) throws DataRunException {
        // nothing
    }
}
