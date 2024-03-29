package com.bee.admin.controller.system;

import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.services.system.IAppVerService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by suntongwei on 15/5/4.
 */
@Auth
@Controller
@RequestMapping("/admin/app")
public class AdminAppController {

    @Autowired
    private IAppVerService appVerService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("system/AppList");
        mav.addObject("AppList", appVerService.getAppVerList());
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("system/AppNew").addObject("selects", Consts.GetAppVerSelect());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(AppVer appVer, MultipartFile file, HttpServletRequest req) {
        try {
            appVerService.saveAppVer(appVer, file, req);
            return index();
        } catch (DataRunException e) {
            return create().addObject("msg", "数据保存异常");
        } catch (IOException ex) {
            return create().addObject("msg", "文件保存异常");
        }
    }

    @RequestMapping(value = "/{aid}", method = RequestMethod.DELETE)
    public ModelAndView delete(Long aid, HttpServletRequest req) {
        try {
            appVerService.deleteAppVer(aid, req);
            return index();
        } catch(DataRunException e) {
            return index().addObject("msg", "删除失败");
        }

    }
}
