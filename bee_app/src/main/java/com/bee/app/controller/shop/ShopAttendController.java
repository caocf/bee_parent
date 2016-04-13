package com.bee.app.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.services.shop.app.IShopAttendAppService;
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
 * v1.1.1删除该接口
 * Created by suntongwei on 15/11/28.
 */
@RestController
@RequestMapping("/v1/shop/{shopId}/attend")
@Deprecated
public class ShopAttendController {

    @Autowired
    private IShopAttendAppService shopAttendAppService;

    /**
     * 获取商家出勤表
     * Map<String(组名), List<ShopAttend>>
     *
     * @param shopId
     * @return
     */
    @Deprecated
    @RequestMapping(method = RequestMethod.GET)
    public ResponseMap<String, List<ShopAttend>> getShopAttend(@PathVariable Long shopId) {
        ResponseMap<String, List<ShopAttend>> res = new ResponseMap<>();
        List<ShopAttend> shopAttends =  shopAttendAppService.getShopAttendByShopId(shopId);
        if (shopAttends != null && !shopAttends.isEmpty()) {
            res.setResult(new HashMap<String, List<ShopAttend>>());
            for (ShopAttend item : shopAttends) {
                if (!res.getResult().containsKey(item.getGroupName())) {
                    res.getResult().put(item.getGroupName(), new ArrayList<ShopAttend>());
                }
                res.getResult().get(item.getGroupName()).add(item);
            }
        }
        res.setCode(Codes.Success);
        return res;
    }

}
