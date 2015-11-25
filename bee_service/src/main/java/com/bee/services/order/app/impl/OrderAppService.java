package com.bee.services.order.app.impl;

import com.bee.client.params.order.OrderListRequest;
import com.bee.dao.order.app.OrderAppDao;
import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.bee.services.order.app.IOrderAppService;
import com.bee.services.order.impl.OrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/25.
 */
@Service
public class OrderAppService extends OrderService implements IOrderAppService {

    @Autowired
    private OrderAppDao orderAppDao;


    /**
     *
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListParam param) {
        return orderAppDao.getAppOrderListByParam(param);
    }

    /**
     * 查询订单
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderItem queryOrderItemById(long orderId) {
        return orderAppDao.queryOrderItemById(orderId);
    }

    @Override
    public void cancelOrder(long id) throws DataRunException {

    }
}
