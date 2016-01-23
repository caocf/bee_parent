package com.bee.app.travel.bean;

import com.bee.pojo.user.User;

/**
 * Created by suntongwei on 16/1/18.
 */
public class TravelUser implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1161993369525790414L;

    // 用户
    private User user;
    // 加入时间
    private Long joinTime;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }
}
