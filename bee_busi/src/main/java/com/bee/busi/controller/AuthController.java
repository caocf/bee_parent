package com.bee.busi.controller;

import com.bee.busi.params.BusiAuthLoginResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.bee.services.shop.busi.IShopUserBusiService;
import com.bee.services.user.busi.IUserBusiService;
import com.qsd.framework.security.SecuritySessionFactory;
import com.qsd.framework.security.consts.SecurityConsts;
import com.qsd.framework.security.encrypt.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
public class AuthController {

    @Autowired
    private IUserBusiService userService;
    @Autowired
    private IShopUserBusiService shopUserBusiService;

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BusiAuthLoginResponse login(String account, String password, HttpServletRequest req) {
        BusiAuthLoginResponse res = new BusiAuthLoginResponse();
        User user = userService.getUserByAccount(account);
        if(user != null && user.getType() == Consts.User.Type.BusiUser) {
            // 登录成功
            if(user.getPassword().equals(Md5.encodePassword(password))) {
                addUserSession(user, req);
                res.setIsFirstLogin(Consts.User.BusiInitPassword.equals(password) ? Consts.True : Consts.False);
                res.setShopUser(shopUserBusiService.getShopUserByLogin(user.getUid()));
                res.setFlag(Consts.True);
                res.setCode(Codes.Success);
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
}
