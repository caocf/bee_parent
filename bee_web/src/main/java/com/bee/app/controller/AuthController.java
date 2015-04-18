package com.bee.app.controller;

import com.bee.client.params.user.AuthLoginResponse;
import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.bee.commons.Codes;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.SecuritySessionFactory;
import com.qsd.framework.security.consts.SecurityConsts;
import com.qsd.framework.security.encrypt.Md5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/4/15.
 */
@RestController
public class AuthController {

    // Log
    private final Logger Log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthLoginResponse login(String account, String password, HttpServletRequest req) {
        AuthLoginResponse res = new AuthLoginResponse();
        User user = userService.getUserByAccount(account);
        if(user != null) {
            // 登录成功
            if(user.getPassword().equals(Md5.encodePassword(password))) {
                res.setFlag(Consts.True);
                res.setUser(user);
                addUserSession(user, req);
            } else {
                res.setFlag(Consts.False);
                res.setCode(Codes.User.LoginPass);
                res.setMsg("用户密码错误");
            }
        } else {
            res.setFlag(Consts.False);
            res.setCode(Codes.User.LoginAccount);
            res.setMsg("用户不存在");
        }
        return res;
    }

    /**
     * 把登录用户放入session中
     *
     * @param user
     * @param req
     */
    private void addUserSession(User user, HttpServletRequest req) {
        user.setPassword(null);
        SecuritySessionFactory.setSecuritySession(user);
        req.getSession().setAttribute(SecurityConsts.HttpSessionName, user);
    }

    /**
     * 注册用户
     *
     * @param user
     * @param req
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public AuthLoginResponse register(User user, HttpServletRequest req) {
        AuthLoginResponse res = new AuthLoginResponse();
        try {
            User u = userService.getUserByAccount(user.getPhone());
            if(u != null) {
                res.setFlag(Consts.False);
                res.setCode(Codes.User.AccountExist);
                res.setMsg("手机号已存在");
            } else {
                userService.createUser(user);
                addUserSession(user, req);
                res.setFlag(Consts.True);
                res.setUser(user);
            }
        } catch(DataRunException e) {
            Log.error("AuthController register error.", e);
            res.setFlag(Consts.False);
            res.setCode(Codes.User.Register);
            res.setMsg("注册失败");
        }
        return res;
    }


}
