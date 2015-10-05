package com.bee.app.model.user;

/**
 * 用户数据
 * 主要用户查询用户实时数据
 *
 * Created by suntongwei on 15/10/5.
 */
public class UserInfo implements java.io.Serializable {

    // UID
    private Long uid;
    // 用户等级
    private Integer level;
    // 用户积分
    private Integer integral;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
