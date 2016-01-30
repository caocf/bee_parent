package com.bee.dao.ticket;

import com.bee.commons.SQL;
import com.bee.domain.params.ticket.TicketParam;
import com.bee.pojo.tickets.Ticket;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 16/1/2.
 */
@Repository
public class TicketDao extends JpaDaoSupport<Ticket, Long> {

    /**
     * TicketWithShop
     *
     * @param param
     * @return
     */
    public List<Ticket> getTicketWithShop(TicketParam param) {
        HQLEntity entity = new HQLEntity();
        entity.setEntity(SQL.Ticket.GetTicketWithShop);
        return queryResult(entity);
    }
}
