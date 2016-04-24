package com.bee.admin.controller.shop;

import com.bee.admin.params.shop.AdminShopReplyRequest;
import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.admin.IShopReplyAdminService;
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

    @Autowired
    private IShopReplyAdminService shopReplyAdminService;

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
}
