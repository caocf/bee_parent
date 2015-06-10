package com.bee.client.params.user;

import com.bee.pojo.user.User;
import com.qsd.framework.spring.BaseResponse;

import java.util.List;

/**
 * Created by suntongwei on 15/6/8.
 */
public class UsersResponse extends BaseResponse {

    private static final long serialVersionUID = 2819414673151666730L;

    // 目标用户
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
