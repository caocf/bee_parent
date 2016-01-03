package com.bee.services.ticket.impl;

import com.bee.dao.ticket.UserTicketDao;
import com.bee.services.ticket.IUserTicketService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/1/2.
 */
public abstract class UserTicketService implements IUserTicketService {

    @Autowired
    protected UserTicketDao userTicketDao;
}
