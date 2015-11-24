package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.busi.IShopBusiService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger Log = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private IShopBusiService shopBusiService;

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
        Shop shop = shopBusiService.getShopById(sid);
        if (shop != null) {
            if (shop.getStatus() == Consts.Shop.Status.Close) {
                res.setCode(Codes.Error);
                res.setMsg("商家被管理员关闭，请联系管理员");
            } else {
                try {
                    shop.setStatus(status);
                    shopBusiService.closeShop(shop);
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
        MultipartFile file = req.getFile("thumbnailFile");
        if (null == file) {
            res.setCode(Codes.Error);
            res.setMsg("图片不存在");
            return res;
        }
        String fileName = file.getOriginalFilename().trim().toLowerCase();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        if (!ImageParser.ImageTypeEnum.JPG.toString().equals(ext)
                && !ImageParser.ImageTypeEnum.JPEG.toString().equals(ext)
                && !ImageParser.ImageTypeEnum.PNG.toString().equals(ext)) {
            res.setCode(Codes.Error);
            res.setMsg("图片格式不正确，只支持JPG,JPEG,PNG格式");
            return res;
        }
        shopBusiService.saveShopListImage(sid, req);
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
        MultipartFile file = req.getFile("file");
        if (null == file) {
            res.setCode(Codes.Error);
            res.setMsg("图片不存在");
            return res;
        }
        String fileName = file.getOriginalFilename().trim().toLowerCase();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        if (!ImageParser.ImageTypeEnum.JPG.toString().equals(ext)
                && !ImageParser.ImageTypeEnum.JPEG.toString().equals(ext)
                && !ImageParser.ImageTypeEnum.PNG.toString().equals(ext)) {
            res.setCode(Codes.Error);
            res.setMsg("图片格式不正确，只支持JPG,JPEG,PNG格式");
            return res;
        }
        shopBusiService.saveShopImage(sid, req);
        res.setCode(Codes.Success);
        return res;
    }
}
