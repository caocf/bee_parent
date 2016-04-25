package com.bee.pojo;

import com.bee.pojo.user.User;

/**
 * Created by suntongwei on 16/1/23.
 */
public class BlackList {

    private Long bid;
    private User user;
    private Integer type;

    public Long getBid() {
        return bid;
    }
    public void setBid(Long bid) {
        this.bid = bid;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
}
