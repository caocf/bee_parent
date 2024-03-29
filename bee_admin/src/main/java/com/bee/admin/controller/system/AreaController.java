package com.bee.admin.controller.system;

import com.bee.commons.AuthName;
import com.bee.pojo.Area;
import com.bee.services.system.admin.IAreaAdminService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController {

    @Autowired
    private IAreaAdminService areaService;

    /**
     *
     * @return
     */
    @Auth(name = AuthName.Area)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("system/AreaList");
        mav.addObject("result", areaService.getAreaListAll());
        return mav;
    }

    /**
     * 获取地区列表
     * 地区控件查询
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Area> getAreaById(@PathVariable Long id) {
        return areaService.getAreaListById(id);
    }

    /**
     * 进去新增地区
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("system/AreaNew");
    }

    /**
     * 保存地区
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Area area) {
        try {
            areaService.addArea(area);
            return index();
        } catch (DataRunException e) {
            ModelAndView mav = create();
            mav.addObject("msg", "保存出错，请重试");
            mav.addObject("result", area);
            return mav;
        }
    }

    /**
     * 进去修改界面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("system/AreaNew");
        mav.addObject("result", areaService.getAreaById(id));
        return mav;
    }

    /**
     * 更新地区
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable Long id, Area area) {
        try {
            areaService.updateArea(area);
            return index();
        } catch (DataRunException e) {
            return edit(id).addObject("msg", "更新失败，请重试");
        }
    }
}
