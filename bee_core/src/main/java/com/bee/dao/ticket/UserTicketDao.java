package com.bee.dao.ticket;

import com.bee.commons.SQL;
import com.bee.domain.params.ticket.UserTicketParam;
import com.bee.pojo.tickets.UserTicket;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.bean.SQLEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 16/1/2.
 */
@Repository
public class UserTicketDao extends JpaDaoSupport<UserTicket, Long> {

    /**
     * 获取用户所有优惠券
     *
     * @param param
     * @return
     */
    public List<UserTicket> getUserTicket(UserTicketParam param) {
        if (null == param || null == param.getUserId() || param.getUserId() < 1) {
            return new ArrayList<>();
        }
        HQLEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.Ticket.GetOrderTicket);
        if (param.getUserId() != null && param.getUserId() > 0) {
            sb.append(" AND A.user.uid = ?");
            entity.setParam(param.getUserId());
        }
        if (param.getStatus() != null) {
            sb.append(" AND A.status = ?");
            entity.setParam(param.getStatus());
        }
        if (param.getShopId() != null && param.getShopId() > 0) {
            sb.append(" AND (C.sid = ? OR C.sid = ?)");
            entity.setParam(0);
            entity.setParam(param.getShopId());
        }
        if (param.getOrderId() != null && param.getOrderId() > 0) {
            sb.append(" AND A.order.oid = ?");
            entity.setParam(param.getOrderId());
        }
        entity.setEntity(sb);
        return queryResult(entity);
    }
}
