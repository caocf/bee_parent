package com.bee.admin.controller.system;

import com.qsd.framework.security.annotation.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/4/24.
 */
@Auth
@Controller
@RequestMapping("/admin/system")
public class AdminSystemController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();

        return mav;
    }

}
