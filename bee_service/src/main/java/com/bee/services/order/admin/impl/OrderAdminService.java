package com.bee.services.order.admin.impl;

import com.bee.client.params.order.AdminOrderListRequest;
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
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    public void cancelOrder(long id) throws DataRunException {
        // nothing...
    }


    @Override
    @Transactional
    public void changeOrderNum(long oid, int num) throws DataRunException {

    }
}
