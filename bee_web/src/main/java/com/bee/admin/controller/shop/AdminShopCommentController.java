package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopCommentService;
import com.bee.services.user.IUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/10/29.
 */
@Auth
@Controller
@RequestMapping("/admin/shop/{sid}/comment")
public class AdminShopCommentController {

    @Autowired
    private IShopCommentService shopCommentService;
    @Autowired
    private IUserService userService;


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

    /**
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        return new ModelAndView("shop/ShopCommentNew");
    }


    /**
     * 增加评论
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopComment shopComment, String userName) {
        try {
            // 检查用户名是否存在，如不存在，则创建用户
            User user = userService.getUserByNick(userName);
            if (null == user) {
                // 如果不存在用，则创建用户
                user = new User();
                user.setPhone("00000000000");
                user.setName(userName);
                user.setPassword(Consts.User.BusiInitPassword);
                user.setType(Consts.User.Type.AppUser);
                user.setPath("");
                user.setUrl("");
                user.setExp(0);
                user.setCreateTime(System.currentTimeMillis());
                user.setAlipay("");
                user.setCash(0d);
                user.setDevice("00000000000");
                user.setIntegral(0);
                user.setLevel(0);
                userService.createUser(user);
            }
            shopComment.setShop(new Shop(sid));
            shopComment.setUser(user);
            shopComment.setOrder(new Order(0));
            shopCommentService.save(shopComment);
            return index(sid, new AdminShopCommentRequest());
        } catch (DataRunException e) {
            return create(sid).addObject("msg", "评论失败");
        }
    }
}
