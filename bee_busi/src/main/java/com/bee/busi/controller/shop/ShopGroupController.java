package com.bee.busi.controller.shop;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.busi.params.shop.ShopGroupSaveResponse;
import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.busi.IShopGroupBusiService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/shop/{sid}/group")
public class ShopGroupController {

    @Autowired
    private IShopGroupBusiService shopGroupBusiService;

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<BusiShopGroup> getShopGroupByShopId(@PathVariable Long sid) {
        return shopGroupBusiService.getShopGroupByShopId(sid);
    }

    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ShopGroupSaveResponse saveShopGroup(ShopGroup shopGroup) {
        ShopGroupSaveResponse res = new ShopGroupSaveResponse();
        try {
            shopGroupBusiService.saveShopGroup(shopGroup);
            res.setShopGroupId(shopGroup.getSgId());
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存出错，请重试");
        }
        return res;
    }

    /**
     *
     * @param shopGroup
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public BaseResponse updateShopGroup(ShopGroup shopGroup) {
        BaseResponse res = new BaseResponse();
        try {
            shopGroupBusiService.updateShopGroup(shopGroup);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存出错，请重试");
        }
        return res;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/{shopGroupId}", method = RequestMethod.DELETE)
    public BaseResponse deleteShopGroup(@PathVariable Long sid, @PathVariable Long shopGroupId) {
        BaseResponse res = new BaseResponse();
        try {
            shopGroupBusiService.deleteShopGroup(sid, shopGroupId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除出错，请重试");
        }
        return res;
    }
}
