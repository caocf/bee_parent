package com.bee.app.controller.user;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.ticket.TicketList;
import com.bee.domain.params.ticket.UserTicketParam;
import com.bee.pojo.tickets.Ticket;
import com.bee.pojo.tickets.UserTicket;
import com.bee.services.ticket.app.IUserTicketAppService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.domain.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 16/1/1.
 */
@RestController
@RequestMapping("/v1/user/{userId}/ticket")
public class UserTicketController {

    @Autowired
    private IUserTicketAppService userTicketAppService;

    /**
     * 获取用户所有优惠券集合
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<TicketList> getTickets(@PathVariable Long userId, UserTicketParam param) {
        ResponseArray<TicketList> res = new ResponseArray<>();
        param.setUserId(userId);
        res.setResult(userTicketAppService.getUserTickets(param));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 获取用户可用优惠券数量
     *
     * @return
     */
    @RequestMapping(value = "/num", method = RequestMethod.GET)
    public ResponseObject<Integer> getTicketNum(@PathVariable Long userId, UserTicketParam param) {
        ResponseObject<Integer> res = new ResponseObject<>();
        param.setUserId(userId);
        res.setResult(userTicketAppService.getUserTickets(param).size());
        res.setCode(Codes.Success);
        return res;
    }

}
