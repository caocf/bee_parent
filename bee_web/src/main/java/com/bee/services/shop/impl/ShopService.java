package com.bee.services.shop.impl;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.ImageDao;
import com.bee.dao.find.FindDao;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopFocusDao;
import com.bee.dao.shop.ShopImageDao;
import com.bee.dao.user.UserFriendDao;
import com.bee.image.ImageParser;
import com.bee.image.impl.ShopListImage;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.modal.ShopMap;
import com.bee.pojo.Image;
import com.bee.pojo.find.Find;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopFocus;
import com.bee.pojo.user.User;
import com.bee.pojo.user.UserFriend;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopDao shopDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private FindDao findDao;

    public List<Shop> getShopAll() {
        return shopDao.findAll();
    }

    public PagingResult<Shop> queryShopList(AdminShopListRequest req) {
        return shopDao.queryShopList(req);
    }

    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest req) {
        return shopDao.queryAppShopList(req);
    }

    public List<ShopListItem> queryRecommendShop(long uid) {
        return shopDao.queryRecommendShop(uid);
    }

    @Override
    @Transactional
    public void addShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException {

        try {

            shop.setCreateTime(System.currentTimeMillis());
            shop.setIdentity("S" + shop.getCreateTime());
            shop.setPrice(0d);
            shop.setStatus(Consts.Shop.Status.Run);
            shop.setIsBack(Consts.False);
            if(null == shop.getSort()) {
                shop.setSort(100);
            }

            // 保存商家信息
            shopDao.save(shop);

            // 保存列表缩略图
            if (req.getFile("thumbnailFile") != null) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopListThum).generate(req, req.getFile("thumbnailFile"));
            }

            // 保存商家门店图
            if (req.getFile("file") != null) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopImage).generate(req, req.getFile("file"));
            }

            // 保存商家推广图
            if (req.getFile("recommendFile") != null) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopRecommend).generate(req, req.getFile("recommendFile"));
            }

            /**
             * 加入到发现推广中
             */
            Find find = new Find();
            find.setContent("新店加入，欢迎大家前往");
            find.setCreateTime(System.currentTimeMillis());
            find.setShop(shop);
            find.setUser(new User(1l));
            findDao.save(find);

        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public Shop getShopById(long sid) {
        return shopDao.getShopById(sid);
    }

    @Override
    public ShopListItem getShopItemById(long sid) {
        return shopDao.getShopItemById(sid);
    }

    @Override
    @Transactional
    public void deleteShop(long sid) throws DataRunException {
        Shop shop = shopDao.findById(sid);
        shop.setStatus(Consts.Shop.Status.Close);
        shopDao.update(shop);
    }

    @Override
    @Transactional
    public void updateShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException {

        try {
            // 修改缩略图
            MultipartFile thumFile = req.getFile("thumbnailFile");
            if (thumFile != null && thumFile.getSize() > 0) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopListThum).generate(req, thumFile);
            }

            // 修改主图
            MultipartFile file = req.getFile("file");
            if (file != null && file.getSize() > 0) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopImage).generate(req, file);
            }

            // 修改推广图
            MultipartFile recommendFile = req.getFile("recommendFile");
            if (recommendFile != null && recommendFile.getSize() > 0) {
                req.setAttribute("shopId", shop.getSid());
                ImageParser.getImageParser(ImageParser.ImageType.ShopRecommend).generate(req, recommendFile);
            }

            // 保存商家其他信息
            shopDao.update(shop);

        } catch(DataRunException e) {
            throw e;
        }

    }

    @Override
    public List<ShopMap> queryShopMapAll() {
        return shopDao.queryShopMapAll();
    }
}
