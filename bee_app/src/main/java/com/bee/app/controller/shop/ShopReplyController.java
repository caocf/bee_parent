package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.app.IShopReplyAppService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseObject;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/1.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/comment/{commentId}/reply")
public class ShopReplyController {

    @Autowired
    private IShopReplyAppService shopReplyAppService;

    /**
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<ShopReplyListItem> queryShopReplyList(@PathVariable Long shopId,
                                                                @PathVariable Long commentId,
                                                                ShopReplyListParam req) {
        ResponsePaging<ShopReplyListItem> rep = new ResponsePaging<>();
        req.setShopId(shopId);
        req.setCommentId(commentId);
        rep.setResult(shopReplyAppService.getReplyList(req));
        rep.setCode(Codes.Success);
        return rep;
    }


    /**
     * 发布评论
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response saveReply(@PathVariable Long shopId,
                                               @PathVariable Long commentId,
                                               ShopReply shopReply) {
        Response res = new Response();
        if (StringUtil.checkIllegalChar(shopReply.getContent())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容包含非法字符，请重新输入");
            return res;
        }
        try {
            shopReply.setCreateTime(System.currentTimeMillis());
            shopReply.setShopComment(new ShopComment(commentId));
            shopReplyAppService.save(shopReply);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }
}
