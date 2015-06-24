package com.bee.services.shop.impl;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.ImageDao;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopFocusDao;
import com.bee.dao.shop.ShopImageDao;
import com.bee.dao.user.UserFriendDao;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.pojo.Image;
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
            // 保存商家主图
            if (req.getFile("file") != null) {
                MultipartFile file = req.getFile("file");
                String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.ShopListSize, req, file);
                Image image = new Image();
                image.setType(0);
                image.setRemark("");
                image.setCreateTime(System.currentTimeMillis());
                image.setUrl(paths[0]);
                image.setPath(paths[1]);
                image.setSort(100);
                imageDao.save(image);
                shop.setImage(image);
            }

            // 保存商家推荐图
            if (req.getFile("recommedFile") != null) {
                MultipartFile file = req.getFile("recommedFile");
                String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.RecommedSize, req, file);
                Image image = new Image();
                image.setType(0);
                image.setRemark("");
                image.setCreateTime(System.currentTimeMillis());
                image.setUrl(paths[0]);
                image.setPath(paths[1]);
                image.setSort(100);
                imageDao.save(image);
                shop.setRecommedImage(image);
            }

            shop.setCreateTime(System.currentTimeMillis());
            shop.setIdentity("S" + shop.getCreateTime());
            shop.setPrice(0d);
            shop.setStatus(Consts.Shop.Status.Run);
            shop.setIsBack(Consts.False);
            if(null == shop.getSort()) {
                shop.setSort(100);
            }
            shopDao.save(shop);
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
            if (req.getFile("file") != null) {
                MultipartFile file = req.getFile("file");
                Image image = new Image();
                if (shop.getImage().getIid() > 0) {
                    image = imageDao.findById(shop.getImage().getIid());
                    ImageFactory.getInstance().deleteImage(image.getPath());
                } else {
                    image.setIid(null);
                    image.setType(0);
                    image.setRemark("");
                    image.setCreateTime(System.currentTimeMillis());
                    image.setSort(100);
                }
                String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.ShopListSize, req, file);
                image.setUrl(paths[0]);
                image.setPath(paths[1]);
                if (image.getIid() != null && image.getIid() > 0) {
                    imageDao.update(image);
                } else {
                    imageDao.save(image);
                }
                shop.setImage(image);
            }
            if (req.getFile("recommedFile") != null) {
                MultipartFile file = req.getFile("recommedFile");
                Image image = new Image();
                if (shop.getImage().getIid() > 0) {
                    image = imageDao.findById(shop.getImage().getIid());
                    ImageFactory.getInstance().deleteImage(image.getPath());
                } else {
                    image.setIid(null);
                    image.setType(0);
                    image.setRemark("");
                    image.setCreateTime(System.currentTimeMillis());
                    image.setSort(100);
                }
                String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.RecommedSize, req, file);
                image.setUrl(paths[0]);
                image.setPath(paths[1]);
                if (image.getIid() != null && image.getIid() > 0) {
                    imageDao.update(image);
                } else {
                    imageDao.save(image);
                }
                shop.setRecommedImage(image);
            }
            shopDao.update(shop);
        } catch(DataRunException e) {
            throw e;
        }

    }
}
