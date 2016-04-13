package com.bee.admin.controller.user;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.services.system.admin.IAdviceAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 16/4/14.
 */
@RestController
@RequestMapping("/advice")
public class AdviceController {

    public static final String AdviceIndex = "user/AdviceList";

    @Autowired
    private IAdviceAdminService adviceAdminService;

    /**
     * 建议首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(AdminRequestPaging param) {
        ModelAndView mav = new ModelAndView(AdviceIndex);
        mav.addObject("result", adviceAdminService.queryUserAdvice(param));
        return mav;
    }

}
