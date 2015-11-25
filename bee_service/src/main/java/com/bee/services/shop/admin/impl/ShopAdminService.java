package com.bee.services.shop.admin.impl;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.commons.Consts;
import com.bee.dao.find.FindDao;
import com.bee.dao.shop.ShopDao;
import com.bee.image.ImageParser;
import com.bee.pojo.find.Find;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;
import com.bee.services.shop.admin.IShopAdminService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopAdminService extends ShopService implements IShopAdminService {


    @Autowired
    private FindDao findDao;

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<Shop> queryShopList(AdminShopListRequest req) {
        return shopDao.queryShopList(req);
    }

    /**
     * 保存商家
     *
     * @param shop
     * @param req
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void addShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException {

        try {

            shop.setCreateTime(System.currentTimeMillis());
            shop.setIdentity("S" + shop.getCreateTime());
            shop.setPrice(0d);
            shop.setStatus(Consts.Shop.Status.Run);

            if (null == shop.getSort()) {
                shop.setSort(100);
            }
            if (null == shop.getRecommend()) {
                shop.setRecommend(Consts.False);
            }
            // v1.0.5删除
//            if (null == shop.getSortTime()) {
//                shop.setSortTime(0l);
//            }
//            shop.setIsBack(Consts.False);
            shop.setUpdateTime(System.currentTimeMillis());
            if (StringUtil.isNull(shop.getServiceTime())) {
                shop.setServiceTime("13:30-0:30");
            }

            // 保存商家信息
            shopDao.save(shop);

            // 保存列表缩略图
            saveShopListImage(shop.getSid(), req);

            // 保存商家门店图
            saveShopImage(shop.getSid(), req);

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
            find.setType(Consts.Find.Type.ShopNew);
            findDao.save(find);

        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     *
     * @param sid
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShop(long sid) throws DataRunException {
        Shop shop = shopDao.findById(sid);
        shop.setStatus(Consts.Shop.Status.Close);
        shopDao.update(shop);
    }

    /**
     *
     * @param shop
     * @param req
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void updateShop(Shop shop, MultipartHttpServletRequest req) throws DataRunException {

        try {
            if (req != null) {
                // 修改缩略图
                saveShopListImage(shop.getSid(), req);

                // 修改主图
                saveShopImage(shop.getSid(), req);

                // 修改推广图
                MultipartFile recommendFile = req.getFile("recommendFile");
                if (recommendFile != null && recommendFile.getSize() > 0) {
                    req.setAttribute("shopId", shop.getSid());
                    ImageParser.getImageParser(ImageParser.ImageType.ShopRecommend).generate(req, recommendFile);
                }
            }

            // 保存商家其他信息
            if (shop != null) {
                if (null == shop.getRecommend()) {
                    shop.setRecommend(Consts.False);
                }
                shopDao.update(shop);
            }

        } catch(DataRunException e) {
            throw e;
        }

    }


    /**
     *
     * @param shopId
     * @param req
     */
    public void saveShopImage(long shopId, MultipartHttpServletRequest req) {
        MultipartFile file = req.getFile("file");
        if (file != null && file.getSize() > 0) {
            req.setAttribute("shopId", shopId);
            ImageParser.getImageParser(ImageParser.ImageType.ShopImage).generate(req, file);
        }
    }

    /**
     *
     * @param shopId
     * @param req
     */
    public void saveShopListImage(long shopId, MultipartHttpServletRequest req) {
        MultipartFile thumFile = req.getFile("thumbnailFile");
        if (thumFile != null && thumFile.getSize() > 0) {
            req.setAttribute("shopId", shopId);
            ImageParser.getImageParser(ImageParser.ImageType.ShopListThum).generate(req, thumFile);
        }
    }
}
