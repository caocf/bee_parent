package com.bee.client.params.user;

import com.bee.pojo.user.User;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/4/15.
 */
public class AuthLoginResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -3643794676984563131L;

    // 登录标识
    private Integer flag;
    // 用户
    private User user;

    public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
