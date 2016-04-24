package com.bee.admin.controller.system;

import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.AppVer;
import com.bee.services.system.admin.IAppVerAdminService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 16/4/24.
 */
@Controller
@RequestMapping("/appver")
public class AppVerController {

    public static final String AppVerIndex = "system/AppList";
    public static final String AppVerNew = "system/AppNew";

    @Autowired
    private IAppVerAdminService appVerService;

    /**
     * App版本列表首页
     *
     * @return
     */
    @Auth(name = AuthName.AppVer)
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return AppVerIndex;
    }

    /**
     *
     * @return
     */
    @Auth(name = AuthName.AppVer)
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<AppVer> queryShopComment(AdminRequestPaging params) {
        ResponsePaging<AppVer> res = new ResponsePaging<>();
        res.setResult(appVerService.queryAppVerList(params));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 创建一个版本
     *
     * @return
     */
    @Auth(name = AuthName.AppVerNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView(AppVerNew).addObject("selects", Consts.GetAppVerSelect());
    }

    /**
     * 发布一个App版本
     *
     * @return
     */
    @Auth(name = AuthName.AppVerNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(AppVer appVer, MultipartHttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        MultipartFile file = req.getFile("file");
        if (null == file) {
            mav.setViewName(AppVerNew);
            mav.addObject("code", Codes.ParamsError);
            mav.addObject("msg", "文件不存在");
            return mav;
        }
        if (!file.getOriginalFilename().endsWith("apk")) {
            mav.setViewName(AppVerNew);
            mav.addObject("code", Codes.ParamsError);
            mav.addObject("msg", "文件格式错误");
            return mav;
        }
        if (StringUtil.checkIllegalChar(appVer.getRemark())) {
            mav.setViewName(AppVerNew);
            mav.addObject("code", Codes.ParamsError);
            mav.addObject("输入内容包含非法字符，请重新输入");
            return mav;
        }
        try {
            appVerService.saveAppVer(appVer, file, req);
            mav.setViewName(AppVerIndex);
            return mav;
        } catch (DataRunException e) {
            mav.setViewName(AppVerNew);
            mav.addObject("code", Codes.Error);
            mav.addObject("msg", "保存失败");
            return mav;
        }

    }

}
