package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.IShopCommentService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/3.
 */
@RestController
@RequestMapping("/shop/{sid}/comment")
public class ShopCommentController {

    @Autowired
    private IShopCommentService shopCommentService;



    /**
     *
     * @param sid
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse save(@PathVariable Long sid, ShopComment comment) {
        BaseResponse res = new BaseResponse();
        try {
            comment.setShop(new Shop(sid));
            shopCommentService.save(comment);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }
}
