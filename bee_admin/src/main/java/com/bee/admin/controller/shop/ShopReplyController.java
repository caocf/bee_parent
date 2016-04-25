package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopReplyRequest;
import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.shop.ShopReply;
import com.bee.pojo.user.User;
import com.bee.services.shop.admin.IShopReplyAdminService;
import com.bee.services.user.admin.IUserAdminService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suntongwei on 16/4/25.
 */
@Controller
@RequestMapping("/shop/{shopId}/comment/{commentId}/reply")
public class ShopReplyController {

    public static final String ReplyIndex = "shop/ShopReplyList";
    public static final String ReplyNew = "shop/ShopReplyNew";

    @Autowired
    private IShopReplyAdminService shopReplyAdminService;
    @Autowired
    private IUserAdminService userAdminService;

    /**
     * 回复列表首页
     *
     * @return
     */
    @Auth(name = AuthName.ShopReply)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long shopId, @PathVariable Long commentId) {
        return new ModelAndView(ReplyIndex)
                .addObject("shopId", shopId)
                .addObject("commentId", commentId);
    }

    /**
     * 回复列表查询
     *
     * @param params
     * @return
     */
    @Auth(name = AuthName.ShopReply)
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<ShopReply> queryShopReplyList(@PathVariable Long shopId,
                                                        @PathVariable Long commentId,
                                                        AdminShopReplyRequest params) {
        ResponsePaging<ShopReply> res = new ResponsePaging<>();
        AdminShopReplyRequest req = new AdminShopReplyRequest();
        req.setShopId(shopId);
        req.setCommentId(commentId);
        res.setResult(shopReplyAdminService.queryShopReplyList(params));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 删除评论回复
     *
     * @return
     */
    @Auth(name = AuthName.ShopReplyDelete)
    @ResponseBody
    @RequestMapping(value = "/{replyId}", method = RequestMethod.DELETE)
    public Response deleteShopReply(@PathVariable Long shopId, @PathVariable Long commentId,
                                    @PathVariable Long replyId) {
        Response res = new Response();
        try {
            shopReplyAdminService.deleteShopReply(commentId, replyId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败");
        }
        return res;
    }

    /**
     * 创建回复页
     *
     * @param shopId    商家ID
     * @param commentId 评论ID
     * @return
     */
    @Auth(name = AuthName.ShopReplyNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView createShopReply(@PathVariable Long shopId, @PathVariable Long commentId) {
        return new ModelAndView(ReplyNew).addObject("shopId", shopId).addObject("commentId", commentId);
    }

    /**
     * 保存一个回复
     *
     * @param shopId    商家ID
     * @param commentId 评论ID
     * @param shopReply 回复实体
     * @param userName  发表用户
     * @return Response
     */
    @Auth(name = AuthName.ShopReplyNew)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Response saveShopReply(@PathVariable Long shopId, @PathVariable Long commentId,
                                  ShopReply shopReply, String userName) {
        Response res = new Response();
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
            user.setDevice("00000000000");
            user.setIntegral(0);
            user.setLevel(0);
            userAdminService.createUser(user);
        }
        try {
            shopReply.setUser(user);
            shopReply.setShopComment(new ShopComment(commentId));
            shopReplyAdminService.save(shopReply);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存失败");
        }
        return res;
    }
}
