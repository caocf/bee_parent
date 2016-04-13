package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.services.shop.app.IShopTecheeAppService;
import com.qsd.framework.domain.response.ResponseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by suntongwei on 16/4/13.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/techee")
public class ShopTecheeController {

    @Autowired
    private IShopTecheeAppService shopTecheeAppService;

    /**
     * 返回商家出勤表
     *
     * @param shopId 商家ID
     * @return
     */
    @RequestMapping(value = "/attend", method = RequestMethod.GET)
    public ResponseMap<String, List<ShopTecheeAttend>> getShopAttend(@PathVariable Long shopId) {
        ResponseMap<String, List<ShopTecheeAttend>> res = new ResponseMap<>();
        List<ShopTecheeAttend> items =  shopTecheeAppService.queryShopTecheeAttend(shopId);
        if (items != null && !items.isEmpty()) {
            res.setResult(new HashMap<String, List<ShopTecheeAttend>>());
            for (ShopTecheeAttend item : items) {
                if (!res.getResult().containsKey(item.getGroupName())) {
                    res.getResult().put(item.getGroupName(), new ArrayList<ShopTecheeAttend>());
                }
                res.getResult().get(item.getGroupName()).add(item);
            }
        }
        res.setCode(Codes.Success);
        return res;
    }


}
