package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 16/4/11.
 */
@RestController
@RequestMapping("/shop/{sid}/techee")
public class ShopTecheeController {

    @Autowired
    private IShopTecheeBusiService shopTecheeBusiService;

    /**
     * <b>查询商家出勤表</b>
     *
     * @param sid 商家ID
     * @return
     */
    @RequestMapping(value = "/attend", method = RequestMethod.GET)
    public ResponseArray<ShopTecheeAttend> queryShopTecheeAttend(@PathVariable Long sid) {
        ResponseArray res = new ResponseArray();
        res.setResult(shopTecheeBusiService.queryShopTecheeAttend(sid));
        res.setCode(Codes.Success);
        return res;
    }
}
