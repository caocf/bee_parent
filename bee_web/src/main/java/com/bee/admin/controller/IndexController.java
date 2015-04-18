package com.bee.admin.controller;

import com.qsd.framework.security.annotation.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suntongwei on 15/4/17.
 */
@Auth
@Controller
@RequestMapping("/admin")
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }

}
