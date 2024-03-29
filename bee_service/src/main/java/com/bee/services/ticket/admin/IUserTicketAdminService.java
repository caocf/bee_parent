package com.bee.services.ticket.admin;

import com.bee.services.ticket.IUserTicketService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 16/1/10.
 */
public interface IUserTicketAdminService extends IUserTicketService {

    /**
     * 维护用户优惠券信息
     *
     * @throws DataRunException
     */
    void mateUserTicket() throws DataRunException;

}
