package com.bee.app.controller.user;

import com.bee.client.params.user.UserResponse;
import com.bee.commons.Codes;
import com.bee.pojo.user.User;
import com.bee.services.user.IFriendService;
import com.bee.services.user.IUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/5/11.
 */
@RestController
@RequestMapping("/user/{uid}/friend")
public class FriendController {

    // log
    private final Logger LOGGER = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IFriendService friendService;

    /**
     * 根据手机号
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/phone/{phone}", method = RequestMethod.GET)
    public UserResponse findFriend(@PathVariable Long uid, @PathVariable String phone) {
        UserResponse res = new UserResponse();
        User friend = userService.getUserByAccount(phone);
        res.setIsFriend(false);
        if(friend != null) {
            res.setUser(friend);
            res.setIsFriend(friendService.isFriend(uid, friend.getUid()));
        }
        return res;
    }

    /**
     * 添加好友
     *
     * @param uid
     * @param uid2
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse addFriend(@PathVariable Long uid, Long uid2) {
        BaseResponse res = new BaseResponse();
        try {
            friendService.addFriend(uid, uid2);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("添加好友失败");
            LOGGER.error("ERROR: friend add error.", e);
        }
        return res;
    }

    /**
     * 删除好友
     *
     * @return
     */
    @RequestMapping(value = "/{uid2}", method = RequestMethod.DELETE)
    public BaseResponse deleteFriend(@PathVariable Long uid, @PathVariable Long uid2) {
        BaseResponse res = new BaseResponse();
        try {
            friendService.deleteFriend(uid, uid2);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("好友删除失败");
        }
        return res;
    }
}
