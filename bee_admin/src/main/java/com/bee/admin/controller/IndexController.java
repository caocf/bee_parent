package com.bee.admin.controller;

import com.qsd.framework.security.annotation.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/11/7.
 */
@Auth
@Controller
public class IndexController {

    /** 首页 */
    public static final String IndexView = "index";

    /**
     * Home首页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView(IndexView);
    }

}
