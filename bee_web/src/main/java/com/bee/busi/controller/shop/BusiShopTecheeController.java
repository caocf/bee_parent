package com.bee.busi.controller.shop;

import com.bee.busi.params.shop.ShopTecheeSaveResponse;
import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.apache.poi.ss.formula.functions.Code;
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
    public ShopTecheeSaveResponse saveShopTechee(ShopTechee shopTechee) {
        ShopTecheeSaveResponse res = new ShopTecheeSaveResponse();
        try {
            shopTecheeService.saveShopTechee(shopTechee);
            res.setShopTecheeId(shopTechee.getStId());
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存出错，请重试");
        }
        return res;
    }

    /**
     * 更新一个技师
     *
     * @param shopTechee
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public BaseResponse updateShopTechee(ShopTechee shopTechee) {
        BaseResponse res = new BaseResponse();
        try {
            shopTecheeService.updateShopTechee(shopTechee);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("更新失败，请重试");
        }
        return res;
    }


    /**
     * 删除一个技师
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResponse deleteShopTechee(@PathVariable Long id) {
        BaseResponse res = new BaseResponse();
        try {
            shopTecheeService.deleteShopTechee(id);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败，请重试");
        }
        return res;
    }

}
