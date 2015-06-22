package com.bee.client.params.order;

import com.bee.pojo.order.Order;
import com.qsd.framework.spring.AppRequest;

/**
 * Created by suntongwei on 15/6/20.
 */
public class OrderCreateRequest extends AppRequest {

    // serialVersionUID
    private static final long serialVersionUID = -2605809088394960036L;

    private Order order;
    private String orderUserIdentitys;

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public String getOrderUserIdentitys() {
        return orderUserIdentitys;
    }
    public void setOrderUserIdentitys(String orderUserIdentitys) {
        this.orderUserIdentitys = orderUserIdentitys;
    }
}
