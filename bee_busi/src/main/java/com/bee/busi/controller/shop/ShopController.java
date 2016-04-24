package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.response.ServiceSupportResponse;
import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.busi.IShopBusiService;
import com.qsd.framework.domain.response.Response;
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

import java.io.IOException;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger Log = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private IShopBusiService shopBusiService;

    /**
     * 获取商家支持信息
     *
     * @return
     */
    @RequestMapping(value = "/{sid}/support", method = RequestMethod.GET)
    public ServiceSupportResponse getShopServiceSupport(@PathVariable Long sid) {
        ServiceSupportResponse res = new ServiceSupportResponse();
        Shop shop = shopBusiService.getShopById(sid);
        if (shop != null) {
            res.setIsPosCard(shop.getIsPosCard());
            res.setIsFood(shop.getIsFood());
            res.setIsFreeParking(shop.getIsFreeParking());
            res.setIsInvoice(shop.getIsInvoice());
            res.setCode(Codes.Success);
        } else {
            res.setCode(Codes.Error);
            res.setMsg("未查询到商家信息");
        }
        return res;
    }

    /**
     * 保存商家支持信息
     *
     * @return
     */
    @RequestMapping(value = "/{sid}/support", method = RequestMethod.POST)
    public Response saveShopServiceSupport(@PathVariable Long sid, Boolean isPosCard,
                                           Boolean isFreeParking, Boolean isFood, Boolean isInvoice) {
        Response res = new Response();
        try {
            Shop shop = shopBusiService.getShopById(sid);
            if (shop != null) {
                shop.setIsPosCard(isPosCard ? Consts.True : Consts.False);
                shop.setIsFreeParking(isFreeParking ? Consts.True : Consts.False);
                shop.setIsFood(isFood ? Consts.True : Consts.False);
                shop.setIsInvoice(isInvoice ? Consts.True : Consts.False);
                shopBusiService.update(shop);
                res.setCode(Codes.Success);
            } else {
                res.setCode(Codes.Error);
                res.setMsg("未查询到商家信息");
            }
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("更新失败,请重试");
        }
        return res;
    }


    /**
     * 关闭商家
     *
     * @param sid 商家ID
     * @return
     */
    @RequestMapping(value = "/{sid}", method = RequestMethod.DELETE)
    public Response openOrCloseShop(@PathVariable long sid, int status) {
        Response res = new Response();
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
    public Response updateShopListImage(@PathVariable Long sid, MultipartHttpServletRequest req) {
        Response res = new Response();
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
    public Response updateShopImage(@PathVariable Long sid, MultipartHttpServletRequest req) {
        Response res = new Response();
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


    /**
     * 上传商家宣传视频
     *
     * @param shopId
     * @param req
     * @return
     */
    @RequestMapping(value = "/{shopId}/video", method = RequestMethod.POST)
    public Response updateShopVideo(@PathVariable Long shopId, MultipartHttpServletRequest req) {
        Response res = new Response();
        MultipartFile file = req.getFile("file");
        if (null == file) {
            res.setCode(Codes.Error);
            res.setMsg("文件不存在");
            return res;
        }
        if (!file.getOriginalFilename().endsWith("video.mp4")) {
            res.setCode(Codes.Error);
            res.setMsg("文件格式错误");
            return res;
        }
        try {
            shopBusiService.saveShopVideo(shopId, file, req);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("视频上传失败");
        }
        return res;
    }

}
