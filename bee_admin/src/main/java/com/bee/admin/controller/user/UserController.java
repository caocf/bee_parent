package com.bee.admin.controller.user;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.AuthName;
import com.bee.pojo.user.User;
import com.bee.services.user.admin.IUserAdminService;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static final String USER_LIST = "user/UserList";

    @Autowired
    private IUserAdminService userService;

    /**
     * 用户管理首页
     *
     * @return
     */
    @Auth(name = AuthName.User)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(AdminUserListRequest request) {
        ModelAndView mav = new ModelAndView(USER_LIST);
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
