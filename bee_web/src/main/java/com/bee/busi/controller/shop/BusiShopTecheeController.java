package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@RestController
@RequestMapping("/busi/shop/{sid}/group/{gid}/techee")
public class BusiShopTecheeController {

    @Autowired
    private IShopTecheeService shopTecheeService;

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopTechee> getShopTecheeByGroupId(@PathVariable Long gid) {
        return shopTecheeService.getShopTecheeByGroupId(gid);
    }

    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse saveShopTechee(ShopTechee shopTechee) {
        BaseResponse res = new BaseResponse();
        try {
            shopTecheeService.saveShopTechee(shopTechee);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存出错，请重试");
        }
        return res;
    }

}
