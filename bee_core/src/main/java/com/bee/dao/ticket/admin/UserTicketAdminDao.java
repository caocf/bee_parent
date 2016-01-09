package com.bee.dao.ticket.admin;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.ticket.UserTicketDao;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 16/1/10.
 */
@Repository
public class UserTicketAdminDao extends UserTicketDao {


    /**
     * <b>维护用户优惠券</b>
     * 主要用于更新用户优惠券状态,判断是否过期
     *
     * @throws DataRunException
     */
    public void mateUserTicket() throws DataRunException {
        execute(SQL.User.Ticket.MateUserTicket, Consts.Ticket.Status.Normal, System.currentTimeMillis());
    }

}
