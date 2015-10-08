package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.IShopGroupService;
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
@RequestMapping("/busi/shop/{sid}/group")
public class BusiShopGroupController {

    @Autowired
    private IShopGroupService shopGroupService;

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopGroup> getShopGroupByShopId(@PathVariable Long sid) {
        return shopGroupService.getShopGroupByShopId(sid);
    }

    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse saveShopGroup(ShopGroup shopGroup) {
        BaseResponse res = new BaseResponse();
        try {
            shopGroupService.saveShopGroup(shopGroup);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存出错，请重试");
        }
        return res;
    }
}
