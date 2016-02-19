package com.bee.busi.controller.shop;

import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.busi.params.shop.ShopTecheeSaveResponse;
import com.bee.commons.Codes;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
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
@RequestMapping("/shop/{sid}/group/{gid}/techee")
public class ShopTecheeController {

    @Autowired
    private IShopTecheeBusiService shopTecheeBusiService;

    /**
     * 返回商家所有分组
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseArray<BusiShopTechee> getShopTecheeAll(@PathVariable Long sid) {
        ResponseArray<BusiShopTechee> res = new ResponseArray<>();
        res.setResult(shopTecheeBusiService.getShopTecheeByShopId(sid));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopTechee> getShopTecheeByGroupId(@PathVariable Long gid) {
        return shopTecheeBusiService.getShopTecheeByGroupId(gid);
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
            shopTecheeBusiService.saveShopTechee(shopTechee);
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
    public Response updateShopTechee(ShopTechee shopTechee) {
        Response res = new Response();
        try {
            shopTecheeBusiService.updateShopTechee(shopTechee);
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
    public Response deleteShopTechee(@PathVariable Long id) {
        Response res = new Response();
        try {
            shopTecheeBusiService.deleteShopTechee(id);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败，请重试");
        }
        return res;
    }
}
