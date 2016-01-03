package com.bee.dao.order.app;

import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.order.OrderDao;
import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/25.
 */
@Repository
public class OrderAppDao extends OrderDao {

    /**
     * App（C端）获取订单列表
     *
     * @param param
     * @return
     */
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Order.getAppOrderListByParam);
        if (param.getUid() != null) {
            sb.append(" and A.user = ?");
            entity.setParams(param.getUid());
        } else {
            if (param.getDevice() != null && !"".equals(param.getDevice())) {
                sb.append(" and A.device = ?");
                entity.setParams(param.getDevice());
            }
        }
        if (param.getStatus() != null) {
            sb.append(" and A.status " + Consts.Order.Status.Query.getQueryStatus(param.getStatus()));
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
                item.setShopId(NumberUtil.parseLong(obj[5], 0));
                item.setUserName(StringUtil.parseString(obj[6], ""));
                item.setExecTime(NumberUtil.parseLong(obj[7], 0));
                item.setPhone(StringUtil.parseString(obj[8], ""));
                item.setRemark(StringUtil.parseString(obj[9], ""));
                item.setIsBack(NumberUtil.parseInteger(obj[10], Consts.False));
                return item;
            }
        });
        if (param.getIsCurOrder() == Consts.True) {
            entity.setPaging(param);
        }
        sb.append(SQL.Order.getOrderListByParamOrder);
        entity.setEntity(sb.toString());
        return queryWithPagingConver(entity);
    }

    /**
     * 【C端】根据订单ID查询订单详细（OrderDetail）
     *
     * @param orderId
     * @return
     */
    public OrderItem queryOrderItemById(long orderId) {
        return findFirstConverByParams(SQL.Order.QueryOrderByOid, new QueryDataConver<OrderItem>() {
            @Override
            public OrderItem converData(Object[] objects) {
                OrderItem item = new OrderItem();
                item.setNo(StringUtil.parseString(objects[0], ""));
                item.setCreateTime(NumberUtil.parseLong(objects[1], 0));
                item.setStatus(NumberUtil.parseInteger(objects[2], Consts.Order.Status.Unknow));
                item.setAddr(StringUtil.parseString(objects[3], ""));
                item.setShopPhone(StringUtil.parseString(objects[4], ""));
                item.setIsComment(NumberUtil.parseInteger(objects[5], Consts.False));
                // v1.1.0增加
                item.setUid(NumberUtil.parseLong(objects[6], 0));
                return item;
            }
        }, orderId);
    }
}
