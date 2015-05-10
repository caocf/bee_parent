package com.bee.dao.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.Consts;
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
            sb.append(" and A.status " + Consts.Order.Status.Query.getQueryStatus(request.getStatus()));
        }
        if(request.getQueryTime() != null) {
            sb.append(" and A.createTime > ?");
            entity.setParam(request.getQueryTime());
        }
        // 判断是否是实时监控
        if(request.getStatus() != Consts.Order.Status.Query.Monitor) {
            sb.append(SQL.Order.getOrderListByParamOrder);
            entity.setPaging(request);
        }
        entity.setEntity(sb.toString());
        return queryWithPaging(entity);
    }
}
