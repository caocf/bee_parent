package com.bee.admin.controller.market;

import com.bee.admin.params.store.GoodsRequest;
import com.bee.pojo.store.Goods;
import com.bee.services.store.IGoodsService;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/10/26.
 */
@Auth
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
    public ModelAndView index(GoodsRequest request) {
        ModelAndView mav = new ModelAndView("market/StoreList");
        mav.addObject("result", goodsService.getGoodsList(request));
        return mav;
    }

    /**
     * 创建界面
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("market/StoreNew").addObject("action", "new");
    }

    /**
     * 进入修改界面
     *
     * @return
     */
    @RequestMapping(value = "/{gid}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long gid) {
        ModelAndView mav = new ModelAndView("market/StoreNew");
        mav.addObject("goods", goodsService.getGoodsById(gid));
        mav.addObject("action", "edit");
        return mav;
    }


    /**
     * 保存商品
     *
     * @param goods
     * @return
     */
    public ModelAndView save(Goods goods) {
        return null;
    }

}
