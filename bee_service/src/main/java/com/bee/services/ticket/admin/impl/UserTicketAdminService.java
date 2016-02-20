package com.bee.services.ticket.admin.impl;

import com.bee.dao.ticket.admin.UserTicketAdminDao;
import com.bee.pojo.tickets.UserTicket;
import com.bee.services.ticket.admin.IUserTicketAdminService;
import com.bee.services.ticket.impl.UserTicketService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 16/1/10.
 */
@Service
public class UserTicketAdminService extends UserTicketService implements IUserTicketAdminService {

    @Autowired
    private UserTicketAdminDao userTicketAdminDao;

    /**
     * 维护用户优惠券信息
     * 主要判断用户优惠券是否过期,如果过期则会自动设置状态
     *
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void mateUserTicket() throws DataRunException {
        userTicketAdminDao.mateUserTicket();
    }

    /**
     * 返回订单所使用的优惠券信息
     *
     * @param orderId
     * @return
     */
    @Override
    public UserTicket getUserTicketByOrder(long orderId) {
        return userTicketAdminDao.getUserTicketByOrder(orderId);
    }
}
