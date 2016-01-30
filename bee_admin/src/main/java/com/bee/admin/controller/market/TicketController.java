package com.bee.admin.controller.market;

import com.bee.domain.params.ticket.TicketParam;
import com.bee.services.ticket.admin.ITicketAdminService;
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

    @Autowired
    private ITicketAdminService ticketAdminService;

    /**
     * 优惠券列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(TicketParam param) {
        ModelAndView mav = new ModelAndView(TICKET_LIST);
        mav.addObject("Tickets", ticketAdminService.getTicketList(param));
        return mav;
    }
}
