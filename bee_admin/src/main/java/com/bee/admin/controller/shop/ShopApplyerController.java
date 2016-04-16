package com.bee.admin.controller.shop;

import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Applyer;
import com.bee.services.system.admin.IApplyerAdminService;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by suntongwei on 16/4/17.
 */
@Controller
@RequestMapping("/shop/applyer")
public class ShopApplyerController {

    @Autowired
    private IApplyerAdminService applyerAdminService;

    /**
     * 商家申请首页
     *
     * @return
     */
    @Auth(name = AuthName.ShopApplyer)
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "shop/ShopApplyerList";
    }

    /**
     *
     * @param param
     * @return
     */
    @Auth(name = AuthName.ShopApplyer)
    @ResponseBody
    @RequestMapping(value = "json", method = RequestMethod.GET)
    public ResponsePaging<Applyer> queryApplyerList(AdminRequestPaging param) {
        ResponsePaging<Applyer> res = new ResponsePaging<>();
        res.setResult(applyerAdminService.queryApplyerList(param));
        res.setCode(Codes.Success);
        return res;
    }

}
