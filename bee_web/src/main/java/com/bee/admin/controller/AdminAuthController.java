package com.bee.admin.controller;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.security.SecuritySessionFactory;
import com.qsd.framework.security.consts.SecurityConsts;
import com.qsd.framework.security.encrypt.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/4/18.
 */
@Controller
@RequestMapping("/admin")
public class AdminAuthController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 管理员登录
     *
     * @param account
     * @param password
     * @param req
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String account, String password, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUserByAccount(account);
        if(user != null && user.getType() == Consts.User.Type.AdminUser) {
            // 登录成功
            if(user.getPassword().equals(Md5.encodePassword(password))) {
                addUserSession(user, req);
                mav.setViewName("index");
            } else {
                mav.setViewName("login");
                mav.addObject("msg", "用户密码错误");
            }
        } else {
            mav.setViewName("login");
            mav.addObject("msg", "用户不存在");
        }
        return mav;
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
