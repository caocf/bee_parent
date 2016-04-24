package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.commons.Codes;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.app.IShopCommentAppService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
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

    /**
     *
     * @param sid
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response save(@PathVariable Long sid, ShopComment comment) {
        Response res = new Response();
        if (StringUtil.checkIllegalChar(comment.getContent())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容包含非法字符，请重新输入");
            return res;
        }
        try {
            comment.setShop(new Shop(sid));
            shopCommentAppService.save(comment);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }
}
