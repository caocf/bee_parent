package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopReplyRequest;
import com.bee.commons.Codes;
import com.bee.modal.ShopReplyListItem;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.IShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/11.
 */
@RestController
@RequestMapping("/shop/{sid}/comment/{cid}/reply")
public class ShopReplyController {

    @Autowired
    private IShopReplyService shopReplyService;

    /**
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<ShopReplyListItem> queryAppShopReplyList(@PathVariable Long sid, @PathVariable Long cid, ShopReplyRequest req) {
        req.setShopId(sid);
        req.setCommentId(cid);
        return shopReplyService.getAppReplyList(req);
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse saveReply(@PathVariable Long sid, @PathVariable Long cid, ShopReply shopReply) {
        BaseResponse res = new BaseResponse();
        try {
            shopReply.setShopComment(new ShopComment(cid));
            shopReplyService.saveReply(shopReply);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }
}
