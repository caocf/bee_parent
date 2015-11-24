package com.bee.busi.controller.shop;

import com.bee.busi.params.shop.ShopImageSaveResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.app.IShopImageAppService;
import com.bee.services.shop.busi.IShopImageBusiService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/shop/{sid}/image")
public class ShopImageController {

    @Autowired
    private IShopImageBusiService shopImageBusiService;
    @Autowired
    private IShopImageAppService shopImageAppService;

    /**
     * 查询商家所有图片
     *
     * @param sid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<com.bee.domain.modal.app.shop.ShopImage> queryShopImageList(@PathVariable Long sid) {
        return shopImageAppService.queryShopImage(sid);
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
            shopImageBusiService.delShopImage(imageId);
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
        // 判断商户图片数量,目前最多上传30张图片
        // 2015.11.1 增加图片上线数量到30张
        List<ShopImage> shopImageList = shopImageBusiService.queryShopImageByShopId(sid);
        if (shopImageList != null && shopImageList.size() >= Consts.Shop.Image.MaxUploadImageSize) {
            res.setCode(Codes.Shop.ShopImageSizeOut);
            res.setMsg("图片数量已达上限");
            return res;
        }
        try {
            shopImage.setShop(new Shop(sid));
            shopImageBusiService.addShopImage(req, file, shopImage);
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
