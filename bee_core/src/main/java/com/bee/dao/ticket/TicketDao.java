package com.bee.dao.ticket;

import com.bee.pojo.tickets.Ticket;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 16/1/2.
 */
@Repository
public class TicketDao extends JpaDaoSupport<Ticket, Long> {


}
