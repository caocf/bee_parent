package com.bee.dao.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.modal.OrderListItem;
import com.bee.pojo.order.Order;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import com.sun.tools.internal.jxc.apt.Const;
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

    /**
     *
     *
     * @param request
     * @return
     */
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Order.getAppOrderListByParam);
        if (request.getUid() != null) {
            sb.append(" and A.user = ?");
            entity.setParams(request.getUid());
        } else {
            if (request.getDevice() != null && !"".equals(request.getDevice())) {
                sb.append(" and A.device = ?");
                entity.setParams(request.getDevice());
            }
        }
        if (request.getStatus() != null) {
            sb.append(" and A.status " + Consts.Order.Status.Query.getQueryStatus(request.getStatus()));
        }
        entity.setQueryDataConver(new QueryDataConver<OrderListItem>() {
            @Override
            public OrderListItem converData(Object[] obj) {
                OrderListItem item = new OrderListItem();
                item.setName(StringUtil.parseString(obj[0], ""));
                item.setTime(NumberUtil.parseLong(obj[1], 0));
                item.setNum(NumberUtil.parseInteger(obj[2], 0));
                item.setStatus(NumberUtil.parseInteger(obj[3], Consts.Order.Status.Create));
                item.setOid(NumberUtil.parseLong(obj[4], 0));
                return item;
            }
        });
        if (request.getIsCurOrder() == Consts.True) {
            entity.setPaging(request);
        }
        sb.append(SQL.Order.getOrderListByParamOrder);
        entity.setEntity(sb.toString());
        return queryWithPagingConver(entity);
    }
}
