package com.bee.app.controller.store;

import com.bee.app.model.store.UserConvertListItem;
import com.bee.app.params.store.UserConvertQueryRequest;
import com.bee.commons.Codes;
import com.bee.pojo.store.UserConvert;
import com.bee.services.store.IUserConvertService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/21.
 */
@RestController
@RequestMapping("/user/{uid}/convert")
public class UserConvertController {

    @Autowired
    private IUserConvertService userConvertService;

    /**
     * 兑换商城物品
     *
     * @return
     */
    @RequestMapping(value = "/{goodsId}", method = RequestMethod.POST)
    public BaseResponse convertGoods(@PathVariable Long uid, @PathVariable Long goodsId) {
        BaseResponse res = new BaseResponse();
        try {
            userConvertService.saveUserConvert(uid, goodsId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            if (e.getErrorCode() == Codes.Store.StockError) {
                res.setCode(Codes.Store.StockError);
                res.setMsg("非常抱歉，该商品没有库存");
            } else if (e.getErrorCode() == Codes.Store.IntegralNotEnough) {
                res.setCode(Codes.Store.IntegralNotEnough);
                res.setMsg("您没有足够的积分");
            } else {
                res.setCode(Codes.Error);
                res.setMsg("服务器异常，请稍后重试");
            }
        }
        return res;
    }

    /**
     * 查询兑换记录
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<UserConvertListItem> queryUserConverList(@PathVariable Long uid, UserConvertQueryRequest req) {
        req.setUserId(uid);
        return userConvertService.queryUserConverList(req);
    }

}
