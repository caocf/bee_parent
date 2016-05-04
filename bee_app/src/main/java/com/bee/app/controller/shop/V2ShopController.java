package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;
import com.bee.services.shop.app.IShopAppService;
import com.bee.services.stat.app.IShopStatAppService;
import com.qsd.framework.domain.response.ResponseObject;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 16/5/4.
 */
@RestController
@RequestMapping("/v2/shop")
public class V2ShopController {

    @Autowired
    private IShopAppService shopAppService;

    @Autowired
    private IShopStatAppService shopStatAppService;

    /**
     * 查询商家
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseObject<ShopItem> getShopItem(@PathVariable Long id, Long uid) {
        ResponseObject<ShopItem> res = new ResponseObject<>();
        // 增加商家浏览统计
        try {
            shopStatAppService.addShopStat(new Shop(id),
                    null == uid || uid < 0 ? new User(0l) : new User(uid));
        } catch (DataRunException e) {}
        // 获取商家信息
        res.setResult(shopAppService.getShopItem(id));
        res.setCode(Codes.Success);
        return res;
    }
}
