package com.bee.app.controller.user;

import com.bee.client.params.user.UserResponse;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.commons.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/4/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据手机号或标识获取用户信息
     *
     * @param phone
     * @param identity
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public UserResponse getUserByParams(String phone, String identity) {
        UserResponse res = new UserResponse();
        if(!StringUtil.isNull(phone)) {
            res.setUser(userService.getUserByAccount(phone));
        }
        if(!StringUtil.isNull(identity)) {
            res.setUser(userService.getUserByIdentity(identity));
        }
        return res;
    }

}
