package com.bee.admin.controller.market;

import com.bee.services.store.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/10/26.
 */
@Controller
@RequestMapping("/admin/store")
public class AdminStoreController {

    @Autowired
    private IGoodsService goodsService;

    /**
     * 积分商城首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("market/StoreList");

        return mav;
    }

}
