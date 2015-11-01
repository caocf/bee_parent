package com.bee.admin.controller.user;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/27.
 */
@Auth
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户管理首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(AdminUserListRequest request) {
        ModelAndView mav = new ModelAndView("user/UserList");
        mav.addObject("result", userService.queryUserListByParams(request));
        mav.addObject("params", request);
        return mav;
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public PagingResult<User> queryUserList(AdminUserListRequest request) {
        return userService.queryUserListByParams(request);
    }

}
