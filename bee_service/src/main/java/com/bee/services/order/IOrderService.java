package com.bee.services.order;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderService {

    /**
     * 取消订单
     *
     * @param id
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void cancelOrder(long id) throws DataRunException;

}
