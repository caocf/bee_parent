package com.bee.admin.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/27.
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    /**
     * 用户管理首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("user/UserList");
        return mav;
    }

}
