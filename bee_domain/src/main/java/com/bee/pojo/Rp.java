package com.bee.pojo;

import com.bee.pojo.user.User;

/**
 * 用户RP值,每个用户将初始100RP值
 *
 * Created by suntongwei on 16/1/31.
 */
public class Rp {

    private Long rid;
    private User user;
    private Integer score;
    private String device;

    public Long getRid() {
        return rid;
    }
    public void setRid(Long rid) {
        this.rid = rid;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
}
