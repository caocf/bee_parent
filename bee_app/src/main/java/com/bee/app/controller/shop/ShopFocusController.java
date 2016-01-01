package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.services.shop.app.IShopFocusAppService;
import com.qsd.framework.domain.response.ResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/17.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/focus")
public class ShopFocusController {

    @Autowired
    private IShopFocusAppService shopFocusAppService;

    /**
     * <b>返回用户收藏商家列表</b>
     *
     * @see com.bee.domain.modal.app.shop.ShopFavorite
     * @return ResponsePaging
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<ShopFavorite> getShopFavoritesByUser(ShopFocusListParam param) {
        ResponsePaging<ShopFavorite> res = new ResponsePaging<>();
        // 检查参数
        if (null == param.getUid() || param.getUid() < 1) {
            res.setCode(Codes.ParamsError);
            res.setMsg("参数错误");
            return res;
        }
        res.setResult(shopFocusAppService.getShopFocusListByParam(param));
        res.setCode(Codes.Success);
        return res;
    }




}
