package com.bee.app.controller.user;

import com.bee.pojo.tickets.Ticket;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 16/1/1.
 */
@RestController
@RequestMapping("/v1/ticket")
public class TicketController {


    /**
     * 获取用户所有优惠券集合
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<Ticket> getTickets() {
        ResponseArray<Ticket> res = new ResponseArray<>();

        return res;
    }


}
