package com.bee.admin.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.shop.ShopConfig;
import com.bee.services.shop.admin.IShopConfigAdminService;
import com.qsd.framework.domain.response.ResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by suntongwei on 16/4/29.
 */
@Controller
@RequestMapping("/shop/{shopId}/video")
public class ShopVideoController {

    public static final String IndexView = "shop/ShopVideo";

    @Autowired
    private IShopConfigAdminService shopConfigAdminService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return IndexView;
    }

    /**
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<ShopConfig> queryShopVideoList(AdminRequestPaging param) {
        ResponsePaging<ShopConfig> res = new ResponsePaging<>();
        res.setResult(shopConfigAdminService.queryShopConfigList(param));
        res.setCode(Codes.Success);
        return res;
    }
}
