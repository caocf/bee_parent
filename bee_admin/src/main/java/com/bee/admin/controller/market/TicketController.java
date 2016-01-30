package com.bee.admin.controller.market;

import com.bee.commons.AuthName;
import com.bee.commons.Consts;
import com.bee.domain.params.ticket.TicketParam;
import com.bee.pojo.tickets.Ticket;
import com.bee.services.ticket.admin.ITicketAdminService;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 16/1/31.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    // 优惠券列表
    public static final String TICKET_LIST = "market/TicketList";
    // 新增优惠券
    public static final String TICKET_NEW = "market/TicketNew";

    @Autowired
    private ITicketAdminService ticketAdminService;

    /**
     * 优惠券列表
     *
     * @return
     */
    @Auth(name = AuthName.TicketList)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(TicketParam param) {
        ModelAndView mav = new ModelAndView(TICKET_LIST);
        mav.addObject("Tickets", ticketAdminService.getTicketList(param));
        return mav;
    }

    /**
     * 增加优惠券
     *
     * @return
     */
    @Auth(name = AuthName.TicketNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView(TICKET_NEW).addObject("Types", Consts.Ticket.Type.Select());
    }

    /**
     * 保存一个优惠券
     *
     * @return
     */
    @Auth(name = AuthName.TicketNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Ticket ticket) {
        ModelAndView mav = null;
        return index(new TicketParam());
    }
}
