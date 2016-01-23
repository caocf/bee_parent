package com.bee.app.travel.bean;

import com.bee.pojo.user.User;

/**
 * Created by suntongwei on 16/1/18.
 */
public class GPS implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 935484992494299282L;

    // 用户
    private User user;
    // gps
    private Double lat;
    private Double lon;
    // 创建时间
    private Long createTime;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLon() {
        return lon;
    }
    public void setLon(Double lon) {
        this.lon = lon;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
