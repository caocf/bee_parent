package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.modal.ShopPriceItem;
import com.bee.services.shop.app.IShopGroupAppService;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/11/19.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/group")
public class ShopGroupController {

    @Autowired
    private IShopGroupAppService shopGroupAppService;

    /**
     * 查询商家价格列表
     *
     * @param shopId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<ShopPriceItem> queryShopPrice(@PathVariable Long shopId) {
        ResponseArray<ShopPriceItem> res = new ResponseArray<>();
        res.setResult(shopGroupAppService.queryShopPriceByShopId(shopId));
        res.setCode(Codes.Success);
        return res;
    }

}
