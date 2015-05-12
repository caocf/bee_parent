package com.bee.client.params.user;

import com.bee.pojo.user.User;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/5/12.
 */
public class UserResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -5838311701036959640L;

    // 是否是好友
    private Boolean isFriend;
    // 目标用户
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Boolean getIsFriend() {
        return isFriend;
    }
    public void setIsFriend(Boolean isFriend) {
        this.isFriend = isFriend;
    }
}
