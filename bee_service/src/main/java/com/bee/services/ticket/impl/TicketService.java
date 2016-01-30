package com.bee.services.ticket.impl;

import com.bee.dao.ticket.TicketDao;
import com.bee.services.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/1/31.
 */
public abstract class TicketService implements ITicketService {

    @Autowired
    protected TicketDao ticketDao;
}
