package com.bee.client.params.order;

import com.bee.pojo.order.Order;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/9/11.
 */
public class OrderCreateResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -1694451256802782687L;

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
