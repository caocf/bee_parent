package com.bee.services.order.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderCreateRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Consts;
import com.bee.dao.order.OrderDao;
import com.bee.modal.OrderListItem;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/4/24.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        return orderDao.getOrderListByParam(request);
    }

    @Override
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request) {
        return orderDao.getAppOrderListByParam(request);
    }

    @Override
    @Transactional
    public void createOrder(OrderCreateRequest req) throws DataRunException {
        try {

            long createOrderTime = System.currentTimeMillis();

            // 创建主订单
            req.getOrder().setType(Consts.Order.Type.Master);
            req.getOrder().setCreateTime(createOrderTime);
            req.getOrder().setStatus(Consts.Order.Status.Execute);
            orderDao.save(req.getOrder());

            // 创建子订单
            if (req.getOrderUserIdentitys() != null && !"".equals(req.getOrderUserIdentitys())) {
                String[] identitys = req.getOrderUserIdentitys().split(",");
                for (String identity : identitys) {
                    Order order = new Order();
                    order.setType(Consts.Order.Type.Child);
                    order.setStatus(Consts.Order.Status.Execute);
                    order.setCreateTime(createOrderTime);
                    order.setExecTime(req.getOrder().getExecTime());
                    order.setNum(req.getOrder().getNum());
                    order.setOrderName(req.getOrder().getOrderName());
                    order.setOrderPhone(req.getOrder().getOrderPhone());
                    order.setRemark(req.getOrder().getRemark());
                    order.setShop(req.getOrder().getShop());
                    order.setUser(new User(Long.valueOf(identity) - Consts.User.IdentityBaseNum));
                    orderDao.save(order);
                }
            }

        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void acceptOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(Consts.Order.Status.Progress);
        orderDao.update(order);
    }

    @Override
    @Transactional
    public void cancelOrder(long id, int status) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(status);
        orderDao.update(order);
    }

    @Override
    @Transactional
    public void finishOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(Consts.Order.Status.Finish);
        orderDao.update(order);
    }
}
