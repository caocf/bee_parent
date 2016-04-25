package com.bee.services.order;

import com.bee.pojo.order.Order;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderService {


    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    void createOrder(Order order) throws DataRunException;

    /**
     * 接受订单
     *
     * @param id
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void acceptOrder(long id) throws DataRunException;

    /**
     * 完成订单
     *
     * @param id
     * @throws DataRunException
     */
    void finishOrder(long id) throws DataRunException;

    /**
     * 取消订单
     *
     * @param id
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void cancelOrder(long id) throws DataRunException;

    /**
     * 修改订单人数
     *
     * @param oid
     * @param num
     * @throws DataRunException
     */
    void changeOrderNum(long oid, int num) throws DataRunException;

}
