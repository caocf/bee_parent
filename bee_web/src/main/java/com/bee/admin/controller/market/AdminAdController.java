package com.bee.admin.controller.market;

import com.bee.pojo.market.Ad;
import com.bee.services.market.IAdService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/5/4.
 */
@Auth
@Controller
@RequestMapping("/admin/ad")
public class AdminAdController {

    @Autowired
    private IAdService adService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("market/AdList");
        mav.addObject("AdList", adService.getAdList());
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("market/AdNew");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Ad ad, MultipartFile file, HttpServletRequest req) {
        try {
            adService.addAd(ad, file, req);
            return index();
        } catch(DataRunException e) {
            return create().addObject("msg", "保存失败");
        }
    }
}
