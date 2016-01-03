package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.commons.AuthName;
import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
import com.bee.services.shop.admin.IShopCommentAdminService;
import com.bee.services.user.admin.IUserAdminService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/shop/{sid}/comment")
public class ShopCommentController {

    @Autowired
    private IShopCommentAdminService shopCommentAdminService;
    @Autowired
    private IUserAdminService userAdminService;


    /**
     * 发表评论首页
     *
     * @return
     */
    @Auth(name = AuthName.ShopComment)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid, AdminShopCommentRequest req) {
        ModelAndView mav = new ModelAndView("shop/ShopCommentList");
        req.setShopId(sid);
        mav.addObject("result", shopCommentAdminService.queryShopComment(req));
        mav.addObject("params", req);
        return mav;
    }

    /**
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopCommentNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        return new ModelAndView("shop/ShopCommentNew");
    }


    /**
     * 增加评论
     *
     * @return
     */
    @Auth(name = AuthName.ShopCommentNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopComment shopComment, String userName) {
        try {
            // 检查用户名是否存在，如不存在，则创建用户
            UserParam param = new UserParam();
            param.setNick(userName);
            User user = userAdminService.getUserByParam(param);
            if (null == user) {
                // 如果不存在用，则创建用户
                user = new User();
                user.setPhone("00000000000");
                user.setName(userName);
                user.setPassword(Consts.User.BusiInitPassword);
                user.setType(Consts.User.Type.TestUser);
//                user.setPath("");
//                user.setUrl("");
                user.setExp(0);
                user.setCreateTime(System.currentTimeMillis());
                user.setAlipay("");
                user.setCash(0d);
                user.setDevice("00000000000");
                user.setIntegral(0);
                user.setLevel(0);
                userAdminService.createUser(user);
            }
            shopComment.setShop(new Shop(sid));
            shopComment.setUser(user);
            shopComment.setOrder(new Order(0));
            shopCommentAdminService.save(shopComment);
            return index(sid, new AdminShopCommentRequest());
        } catch (DataRunException e) {
            return create(sid).addObject("msg", "评论失败");
        }
    }
}
