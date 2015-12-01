package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.bee.services.shop.app.IShopReplyAppService;
import com.qsd.framework.domain.response.ResponsePaging;
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
    public ResponsePaging<ShopReplyListItem> queryAppShopReplyList(@PathVariable Long shopId,
                                                                   @PathVariable Long commentId,
                                                                   ShopReplyListParam req) {
        ResponsePaging<ShopReplyListItem> rep = new ResponsePaging<>();
        req.setShopId(shopId);
        req.setCommentId(commentId);
        rep.setResult(shopReplyAppService.getReplyList(req));
        rep.setCode(Codes.Success);
        return rep;
    }
}
