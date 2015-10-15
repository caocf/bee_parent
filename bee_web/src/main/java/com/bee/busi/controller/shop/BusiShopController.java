package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by suntongwei on 15/8/19.
 */
@RestController
@RequestMapping("/busi/shop")
public class BusiShopController {

    private static final Logger Log = LoggerFactory.getLogger(BusiShopController.class);

    @Autowired
    private IShopService shopService;

    @RequestMapping(value = "/{sid}", method = RequestMethod.PUT)
    public void updateShop() {

    }

    /**
     * 关闭商家
     *
     * @param sid 商家ID
     * @return
     */
    @RequestMapping(value = "/{sid}", method = RequestMethod.DELETE)
    public BaseResponse openOrCloseShop(@PathVariable long sid, int status) {
        BaseResponse res = new BaseResponse();
        Shop shop = shopService.getShopById(sid);
        if (shop != null) {
            if (shop.getStatus() == Consts.Shop.Status.Close) {
                res.setCode(Codes.Error);
                res.setMsg("商家被管理员关闭，请联系管理员");
            } else {
                try {
                    shop.setStatus(status);
                    shopService.updateShop(shop, null);
                    res.setCode(Codes.Success);
                } catch (DataRunException e) {
                    Log.error("BusiShopController.openOrCloseShop error.", e);
                    res.setCode(Codes.Error);
                    res.setMsg("保存状态出错，请重试");
                }
            }
        } else {
            res.setCode(Codes.Error);
            res.setMsg("未知商家");
        }
        return res;
    }


    /**
     * 上传商家列表图片
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/{sid}/edit/image/list", method = RequestMethod.POST)
    public BaseResponse updateShopListImage(@PathVariable Long sid, MultipartHttpServletRequest req) {
        BaseResponse res = new BaseResponse();
        shopService.saveShopListImage(sid, req);
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 上传商家门店图片
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/{sid}/edit/image/face", method = RequestMethod.POST)
    public BaseResponse updateShopImage(@PathVariable Long sid, MultipartHttpServletRequest req) {
        BaseResponse res = new BaseResponse();
        shopService.saveShopImage(sid, req);
        res.setCode(Codes.Success);
        return res;
    }
}
