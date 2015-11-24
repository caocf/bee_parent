package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.commons.Codes;
import com.bee.modal.ShopCommentListItem;
import com.bee.services.shop.app.IShopCommentAppService;
import com.qsd.framework.domain.response.ResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/22.
 */
@RestController
@RequestMapping("/v1/shop/{sid}/comment")
public class ShopCommentController {

    @Autowired
    private IShopCommentAppService shopCommentAppService;

    /**
     *
     *
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<ShopCommentListItem> queryAppShopCommentList(@PathVariable Long sid, ShopCommentRequest req) {
        ResponsePaging<ShopCommentListItem> res = new ResponsePaging<>();
        req.setShopId(sid);
        res.setResult(shopCommentAppService.queryShopComment(req));
        res.setCode(Codes.Success);
        return res;
    }
}
