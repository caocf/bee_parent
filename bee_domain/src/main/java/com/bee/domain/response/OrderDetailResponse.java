package com.bee.domain.response;

import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.ticket.TicketList;
import com.qsd.framework.domain.response.Response;

import java.util.List;

/**
 * Created by suntongwei on 16/1/4.
 */
public class OrderDetailResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = 7114377511590645893L;

    private OrderItem orderItem;
    private List<TicketList> ticketLists;

    public OrderItem getOrderItem() {
        return orderItem;
    }
    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
    public List<TicketList> getTicketLists() {
        return ticketLists;
    }
    public void setTicketLists(List<TicketList> ticketLists) {
        this.ticketLists = ticketLists;
    }
}
