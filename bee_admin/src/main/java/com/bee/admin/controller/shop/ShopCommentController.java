package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
import com.bee.services.shop.admin.IShopAdminService;
import com.bee.services.shop.admin.IShopCommentAdminService;
import com.bee.services.user.admin.IUserAdminService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/shop/{sid}/comment")
public class ShopCommentController {

    public static final String CommentList = "shop/ShopCommentList";
    public static final String CommentNew = "shop/ShopCommentNew";

    @Autowired
    private IShopAdminService shopAdminService;
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
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView(CommentList);
        mav.addObject("shop", shopAdminService.getShopById(sid));
        return mav;
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<ShopComment> queryShopComment(@PathVariable Long sid, AdminShopCommentRequest req) {
        ResponsePaging<ShopComment> res = new ResponsePaging<>();
        req.setShopId(sid);
        res.setResult(shopCommentAdminService.queryShopComment(req));
        res.setCode(Codes.Success);
        return res;
    }



    /**
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopCommentNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid, String shopName) {
        ModelAndView mav = new ModelAndView(CommentNew);
        mav.addObject("sid", sid);
        mav.addObject("shopName", shopName);
        return mav;
    }


    /**
     * 增加评论
     *
     * @return
     */
    @Auth(name = AuthName.ShopCommentNew)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Response save(@PathVariable Long sid, ShopComment shopComment, String userName) {
        Response res = new Response();
        try {
            // 检查用户名是否存在，如不存在，则创建用户
            UserParam param = new UserParam();
            param.setNick(userName);
            param.setType(Consts.User.Type.TestUser);
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
            res.setCode(Codes.Success);
            return res;
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存失败,请重试");
            return res;
        }
    }

    /**
     * 删除评论
     *
     * @param sid
     * @param commentId
     * @return
     */
    @Auth(name = AuthName.ShopCommentDelete)
    @ResponseBody
    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable Long sid, @PathVariable Long commentId) {
        Response res = new Response();
        try {

            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
        }
        return res;
    }
}
