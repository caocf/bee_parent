package com.bee.services.order.impl;

import com.bee.commons.Consts;
import com.bee.commons.IntegralMachine;
import com.bee.commons.LevelMachine;
import com.bee.dao.order.OrderDao;
import com.bee.dao.ticket.UserTicketDao;
import com.bee.dao.user.UserDao;
import com.bee.domain.params.ticket.UserTicketParam;
import com.bee.pojo.order.Order;
import com.bee.pojo.tickets.UserTicket;
import com.bee.pojo.user.User;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class OrderService implements IOrderService {

    @Autowired
    protected OrderDao orderDao;
    @Autowired
    protected UserTicketDao userTicketDao;
    @Autowired
    protected UserDao userDao;

    /**
     * 取消订单同时取消使用的优惠券
     *
     * @throws DataRunException
     */
    protected void cancelOrderAndTicket(Long userId, Long orderId) throws DataRunException {
        UserTicketParam param = new UserTicketParam();
        param.setUserId(userId);
        param.setOrderId(orderId);
        param.setStatus(Consts.Ticket.Status.Useing);
        List<UserTicket> tickets = userTicketDao.getUserTicket(param);
        for (UserTicket ticket : tickets) {
            ticket.setStatus(Consts.Ticket.Status.Normal);
            ticket.setOrder(new Order(0));
            userTicketDao.update(ticket);
        }
    }

    /**
     * 用户取消订单后减去响应用户分数
     *
     * @throws DataRunException
     */
    protected void cancelOrderAndMinus() throws DataRunException {

    }

    /**
     * 完成订单增加用户积分
     *
     * @param user 所属用户
     * @throws DataRunException
     */
    protected void finishOrderUpdateIntegral(User user) throws DataRunException {
        // 先判断是否是注册用户
        if (null == user || user.getUid() < 1) {
            return;
        }
        user.addIntegral(IntegralMachine.OrderFinish);
        user.addExp(LevelMachine.OrderFinish);
        userDao.update(user);
    }
}
