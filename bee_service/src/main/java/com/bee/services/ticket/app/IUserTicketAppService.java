package com.bee.services.ticket.app;

import com.bee.domain.modal.app.ticket.TicketList;
import com.bee.domain.params.ticket.UserTicketParam;
import com.bee.services.ticket.IUserTicketService;

import java.util.List;

/**
 * Created by suntongwei on 16/1/3.
 */
public interface IUserTicketAppService extends IUserTicketService {

    /**
     * 获取用户所有优惠券
     *
     * @return
     */
    List<TicketList> getUserTickets(UserTicketParam param);

}
