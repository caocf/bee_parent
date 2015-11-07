package com.bee.admin.controller;

import com.qsd.framework.security.annotation.Auth;
import org.springframework.stereotype.Controller;

/**
 * Created by suntongwei on 15/11/7.
 */
@Auth
@Controller
public class IndexController {

    /** 首页 */
    public static final String IndexView = "index";

}
