package com.bee.pojo.stat;

import com.bee.pojo.user.User;

/**
 * Created by suntongwei on 15/4/16.
 */
public class UserLoginStat implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1522261428943367989L;

    /**
     * 主键
     */
    private Long ulsId;
    /**
     * 所属用户
     */
    private User user;
    /**
     * 登录时间
     */
    private Long loginTime;

    public Long getUlsId() {
        return ulsId;
    }
    public void setUlsId(Long ulsId) {
        this.ulsId = ulsId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}
