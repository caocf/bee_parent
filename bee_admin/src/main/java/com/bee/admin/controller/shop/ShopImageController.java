package com.bee.admin.controller.shop;

import com.bee.commons.AuthName;
import com.bee.commons.Consts;
import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.admin.IShopImageAdminService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/11/8.
 */
@Controller
@RequestMapping("/shop/{sid}/image")
public class ShopImageController {

    // LOG
    private final Logger Log = LoggerFactory.getLogger(ShopImageController.class);

    @Autowired
    private IShopImageAdminService shopImageService;

    /**
     * 查看商家图片
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopImage)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopImageList");
        List<ShopImage> shopImageList = shopImageService.queryShopImageByShopId(sid);
        mav.addObject("sid", sid);
        mav.addObject("result", shopImageList);
        if(!shopImageList.isEmpty()) {
            mav.addObject("shopName", shopImageList.get(0).getShop().getName());
        }
        return mav;
    }

    /**
     * 创建商家图片
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopImageNew)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long sid) {
        ModelAndView mav = new ModelAndView("shop/ShopImageNew");
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     * 保存商家图片
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopImageNew)
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@PathVariable Long sid, ShopImage shopImage, HttpServletRequest req,
                             @RequestParam(value = "file", required = false) MultipartFile file) {
        if (null == file) {
            return create(sid).addObject("msg", "图片不存在");
        }
        // 对图片格式进行安全性检查
        String fileName = file.getOriginalFilename().trim().toLowerCase();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        if (!ImageParser.ImageTypeEnum.JPG.toString().equals(ext)
            && !ImageParser.ImageTypeEnum.JPEG.toString().equals(ext)
            && !ImageParser.ImageTypeEnum.PNG.toString().equals(ext)) {
            return create(sid).addObject("msg", "图片格式不正确，只支持JPG,JPEG,PNG格式");
        }
        // 对商家图片数量是否已达上线
        List<ShopImage> shopImageList = shopImageService.queryShopImageByShopId(sid);
        if (shopImageList != null && shopImageList.size() >= Consts.Shop.Image.MaxUploadImageSize) {
            return create(sid).addObject("msg", "图片数量已达上限");
        }
        try {
            // 保存图片
            shopImage.setShop(new Shop(sid));
            shopImageService.addShopImage(req, file, shopImage);
            return index(sid);
        } catch (DataRunException e) {
            ModelAndView mav = create(sid);
            mav.addObject("image", shopImage);
            mav.addObject("msg", "保存商家图片出错");
            return mav;
        }
    }

    /**
     * 删除一张图片
     *
     * @param id
     * @return
     */
    @Auth(name = AuthName.ShopImageDelete)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long sid, @PathVariable Long id) {
        try {
            shopImageService.delShopImage(id);
            return index(sid);
        } catch(DataRunException e) {
            Log.error("error: delete ShopImage exception.", e);
            return index(sid).addObject("msg", "删除失败");
        }
    }

    /**
     * 进入修改界面
     *
     * @param sid
     * @return
     */
    @Auth(name = AuthName.ShopImageEdit)
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long sid, @PathVariable Long id) {
        ModelAndView mav = new ModelAndView("shop/ShopImageNew");
        mav.addObject("image", shopImageService.getShopImageById(id));
        mav.addObject("sid", sid);
        return mav;
    }

    /**
     * 更新图片
     *
     * @return
     */
    @Auth(name = AuthName.ShopImageEdit)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable Long sid, @PathVariable Long id, ShopImage shopImage, HttpServletRequest req,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            shopImageService.updateShopImage(req, file, shopImage);
            return index(shopImage.getShop().getSid());
        } catch(DataRunException e) {
            Log.error("error: update ShopImage exception.", e);
            return edit(shopImage.getShop().getSid(), id).addObject("msg", "更新失败");
        }
    }
}
