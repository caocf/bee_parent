package com.bee.dao.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.SQL;
import com.bee.pojo.order.Order;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/4/24.
 */
@Repository
public class OrderDao extends JpaDaoSupport<Order, Long> {

    /**
     * 根据参数获取订单列表
     *
     * @param request
     * @return
     */
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Order.getOrderListByParam);
        if(request.getStatus() != null) {
            sb.append("and A.status = ?");
            entity.setParams(request.getStatus());
        }
        entity.setEntity(sb.toString());
        entity.setPaging(request);
        return queryWithPaging(entity);
    }
}
