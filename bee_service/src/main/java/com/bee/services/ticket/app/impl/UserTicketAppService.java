package com.bee.services.ticket.app.impl;

import com.bee.dao.ticket.app.UserTicketAppDao;
import com.bee.domain.modal.app.ticket.TicketList;
import com.bee.domain.params.ticket.UserTicketParam;
import com.bee.services.ticket.app.IUserTicketAppService;
import com.bee.services.ticket.impl.UserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 16/1/3.
 */
@Service
public class UserTicketAppService extends UserTicketService implements IUserTicketAppService {

    @Autowired
    private UserTicketAppDao userTicketAppDao;

    /**
     * 获取用户所有优惠券
     *
     * @param param
     * @return
     */
    @Override
    public List<TicketList> getUserTickets(UserTicketParam param) {
        return userTicketAppDao.getUserTicketList(param);
    }
}
