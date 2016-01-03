package com.bee.dao.ticket.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.ticket.UserTicketDao;
import com.bee.domain.modal.app.ticket.TicketList;
import com.bee.domain.params.ticket.UserTicketParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 16/1/4.
 */
@Repository
public class UserTicketAppDao extends UserTicketDao {

    /**
     * 获取用户所有优惠券
     *
     * @param param
     * @return
     */
    public List<TicketList> getUserTicketList(UserTicketParam param) {
        if (null == param || null == param.getUserId() || param.getUserId() < 1) {
            return new ArrayList<>();
        }
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.Ticket.GetUserTickets);
        if (param.getUserId() != null && param.getUserId() > 0) {
            sb.append(" AND A.USER = ?");
            entity.setParam(param.getUserId());
        }
        if (param.getStatus() != null) {
            sb.append(" AND A.STATUS = ?");
            entity.setParam(param.getStatus());
        }
        if (param.getShopId() != null && param.getShopId() > 0) {
            sb.append(" AND (B.SHOP = ? OR C.SID = ?)");
            entity.setParam(0);
            entity.setParam(param.getShopId());
        }
        if (param.getOrderId() != null && param.getOrderId() > 0) {
            sb.append(" AND A.T_ORDER = ?");
            entity.setParam(param.getOrderId());
        }
        entity.setQueryDataConver(new QueryDataConver<TicketList>() {
            @Override
            public TicketList converData(Object[] row) {
                TicketList item = new TicketList();
                item.setUserTicketId(NumberUtil.parseLong(row[0], 0));
                item.setTicketId(NumberUtil.parseLong(row[1], 0));
                item.setStatus(NumberUtil.parseInteger(row[2], Consts.Ticket.Status.UnKnow));
                item.setTitle(StringUtil.parseString(row[3], "红包"));
                item.setShopId(NumberUtil.parseLong(row[4], 0));
                item.setShopName(StringUtil.parseString(row[5], ""));
                item.setStartTime(NumberUtil.parseLong(row[6], 0));
                item.setStopTime(NumberUtil.parseLong(row[7], 0));
                item.setPrice(NumberUtil.parseDouble(row[8], 0d));
                item.setType(NumberUtil.parseInteger(row[9], Consts.Ticket.Type.Normal));
                return item;
            }
        });
        entity.setEntity(sb);
        return queryResultConver(entity);
    }
}
