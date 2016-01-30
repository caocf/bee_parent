package com.bee.services.ticket.admin.impl;

import com.bee.domain.params.ticket.TicketParam;
import com.bee.pojo.tickets.Ticket;
import com.bee.services.ticket.admin.ITicketAdminService;
import com.bee.services.ticket.impl.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 16/1/31.
 */
@Service
public class TicketAdminService extends TicketService implements ITicketAdminService {

    /**
     * 获取优惠券列表
     *
     * @param param
     * @return
     */
    @Override
    public List<Ticket> getTicketList(TicketParam param) {
        return ticketDao.getTicketWithShop(param);
    }
}
