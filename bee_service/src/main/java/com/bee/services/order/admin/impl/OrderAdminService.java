package com.bee.services.order.admin.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.pojo.order.Order;
import com.bee.services.order.admin.IOrderAdminService;
import com.bee.services.order.impl.OrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

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
     * @param id
     * @throws DataRunException
     */
    @Override
    public void cancelOrder(long id) throws DataRunException {
        // nothing...
    }
}
