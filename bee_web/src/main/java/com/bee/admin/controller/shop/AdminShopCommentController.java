package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.services.shop.IShopCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/10/29.
 */
@Controller
@RequestMapping("/admin/shop/{sid}/comment")
public class AdminShopCommentController {

    @Autowired
    private IShopCommentService shopCommentService;


    /**
     * 发表评论首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid, AdminShopCommentRequest req) {
        ModelAndView mav = new ModelAndView("shop/ShopCommentList");
        req.setShopId(sid);
        mav.addObject("result", shopCommentService.queryShopComment(req));
        mav.addObject("params", req);
        return mav;
    }


}
