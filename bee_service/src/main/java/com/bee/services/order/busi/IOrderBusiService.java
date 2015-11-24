package com.bee.services.order.busi;

import com.bee.busi.model.order.BusiOrderItem;
import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderBusiService extends IOrderService {

    /**
     * 根据参数查询商户端订单列表
     *
     * @param request
     * @return
     */
    List<BusiOrderListItem> getOrderListByParam(BusiOrderListRequest request);

    /**
     * 根据订单ID查询商户端订单详细
     *
     * @return
     */
    BusiOrderItem getOrderItem(long oid);

    /**
     * 接受订单
     *
     * @param id
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void acceptOrder(long id) throws DataRunException;

    /**
     * 【B端】商家拒绝订单
     *
     * @param id
     * @throws DataRunException
     */
    void rejectOrder(long id) throws DataRunException;

    /**
     * 完成订单
     *
     * @param id
     * @throws DataRunException
     */
    void finishOrder(long id) throws DataRunException;
}
