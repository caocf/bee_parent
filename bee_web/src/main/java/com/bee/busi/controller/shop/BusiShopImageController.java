package com.bee.busi.controller.shop;

import com.bee.busi.params.shop.ShopImageSaveResponse;
import com.bee.commons.Codes;
import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * Created by suntongwei on 15/10/15.
 */
@RestController
@RequestMapping("/busi/shop/{sid}/image")
public class BusiShopImageController {

    @Autowired
    private IShopImageService shopImageService;

    /**
     * 查询商家所有图片
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<ShopImageListItem> queryShopImageList(@PathVariable Long sid) {
        return shopImageService.queryAppShopImage(sid);
    }

    /**
     * 删除图片
     *
     * @param imageId
     */
    @RequestMapping(value = "/{imageId}", method = RequestMethod.DELETE)
    public BaseResponse deleteShopImage(@PathVariable Long imageId) {
        BaseResponse res = new BaseResponse();
        try {
            shopImageService.delShopImage(imageId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("图片删除失败，请重试");
        }
        return res;
    }

    /**
     *
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ShopImageSaveResponse saveShopImage(@PathVariable Long sid, ShopImage shopImage, MultipartHttpServletRequest req) {
        ShopImageSaveResponse res = new ShopImageSaveResponse();
        try {
            // 判断商户图片数量,目前最多上传10张图片
            List<ShopImage> shopImageList = shopImageService.queryShopImageByShopId(sid);
            if (shopImageList != null && shopImageList.size() >= 10) {
                res.setCode(Codes.Shop.ShopImageSizeOut);
                res.setMsg("图片数量已达上限");
                return res;
            }
            shopImage.setShop(new Shop(sid));
            shopImageService.addShopImage(req, req.getFile("file"), shopImage);
            res.setCode(Codes.Success);
            res.setShopImageId(shopImage.getSiid());
            res.setRemark(shopImage.getRemark());
            res.setUrl(shopImage.getUrl());
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("图片保存失败，请重试");
        }
        return res;
    }
}
