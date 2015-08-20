package com.bee.app.controller.user;

import com.bee.client.params.user.UserResponse;
import com.bee.client.params.user.UsersResponse;
import com.bee.commons.Codes;
import com.bee.core.UserCacheFactory;
import com.bee.services.user.IUserService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    /**
     *
     *
     * @param identitys
     * @return
     */
    @RequestMapping(value = "/infos", method = RequestMethod.GET)
    public UsersResponse getUsersByParams(String identitys) {
        UsersResponse res = new UsersResponse();
        if (!StringUtil.isNull(identitys)) {
            String[] identityArray = identitys.split(",");
            if (identityArray != null && identityArray.length > 0) {
                res.setCode(Codes.Success);
                res.setUsers(UserCacheFactory.getInstance().getUsers(identityArray));
                return res;
            }
        }
        res.setCode(Codes.Error);
        return res;
    }



    @RequestMapping(value = "/{uid}/save/avatar", method = RequestMethod.POST)
    public UserResponse saveAvatar(@PathVariable Long uid, MultipartFile file, HttpServletRequest req) {
        UserResponse res = new UserResponse();
        try {
            res.setUser(userService.saveAvatar(uid, file, req));
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/{uid}/save/nick", method = RequestMethod.POST)
    public BaseResponse saveNickName(@PathVariable Long uid, String nickName) {
        BaseResponse res = new BaseResponse();
        try {
            userService.saveNickName(uid, nickName);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            e.printStackTrace();
        }
        return res;
    }
}
