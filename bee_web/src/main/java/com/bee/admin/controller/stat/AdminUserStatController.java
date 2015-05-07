package com.bee.admin.controller.stat;

import com.bee.services.stat.IUserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/5/7.
 */
@Controller
@RequestMapping("/admin/stat/user")
public class AdminUserStatController {

    @Autowired
    private IUserStatService userStatService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView statUserReg() {
        ModelAndView mav = new ModelAndView("stat/StatUser");
        mav.addObject("UserReg30", userStatService.statUserRegStat());
        return mav;
    }
}
