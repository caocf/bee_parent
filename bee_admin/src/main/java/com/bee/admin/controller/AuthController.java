package com.bee.admin.controller;

import com.bee.admin.services.user.IUserService;
import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.security.SecuritySessionFactory;
import com.qsd.framework.security.consts.SecurityConsts;
import com.qsd.framework.security.encrypt.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 鉴权控制器
 *
 * @see com.bee.admin.services.user.IUserService
 * @since v1.0.0
 */
@Controller
public class AuthController {

    /** 登录界面 */
    public static final String LoginView = "login";

    @Autowired
    private IUserService userService;

    /**
     *
     * @return
     * @since v1.0.0
     */
    @RequestMapping(value = {"/login/index"}, method = RequestMethod.GET)
    public ModelAndView login(String returnUrl) {
        return new ModelAndView(LoginView).addObject("returnUrl", returnUrl);
    }

    /**
     * 管理员登录
     *
     * @param account
     * @param password
     * @param req
     * @return ModelAndView OK /index, ERROR: /login
     * @since v1.0.0
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String account, String password, String returnUrl, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUserByAccount(account);
        if(user != null && user.getType() == Consts.User.Type.AdminUser) {
            // 登录成功
            if(user.getPassword().equals(Md5.encodePassword(password))) {
                addUserSession(user, req);
                if (StringUtil.isNull(returnUrl)) {
                    mav.setViewName("redirect:" + IndexController.IndexView);
                } else {
                    if (returnUrl.startsWith("http")) {
                        mav.setViewName(LoginView);
                        return mav;
                    }
                    String afterUrl = File.separator + "admin";
                    if (returnUrl.startsWith(afterUrl)) {
                        returnUrl = returnUrl.substring(afterUrl.length(), returnUrl.length());
                    }
                    mav.setViewName("redirect:" + returnUrl.replaceAll(":0", "&"));
                }
            } else {
                mav.setViewName(LoginView);
                mav.addObject("msg", "用户密码错误");
            }
        } else {
            mav.setViewName(LoginView);
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
