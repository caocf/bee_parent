package com.bee.pojo.tickets;

import com.bee.pojo.user.User;

/**
 * 优惠券
 *
 * Created by suntongwei on 15/12/25.
 */
public class Ticket {

    private Long tid;
    private String name;
    private Integer type;
    private Integer status;
    private User user;
    private Long createTime;
    private Long startTime;
    private Long endTime;
}
