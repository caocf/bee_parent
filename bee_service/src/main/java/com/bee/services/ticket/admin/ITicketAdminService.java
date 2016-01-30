package com.bee.services.ticket.admin;

import com.bee.domain.params.ticket.TicketParam;
import com.bee.pojo.tickets.Ticket;
import com.bee.services.ticket.ITicketService;

import java.util.List;

/**
 * Created by suntongwei on 16/1/31.
 */
public interface ITicketAdminService extends ITicketService {

    /**
     * 获取优惠券列表
     *
     * @param param
     * @return
     */
    List<Ticket> getTicketList(TicketParam param);

}
