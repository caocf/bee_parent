package com.bee.services.find.busi.impl;

import com.bee.commons.Consts;
import com.bee.dao.find.FindImageDao;
import com.bee.dao.shop.ShopImageDao;
import com.bee.domain.params.find.FindSaveParam;
import com.bee.pojo.find.Find;
import com.bee.pojo.find.FindImage;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopImage;
import com.bee.pojo.user.User;
import com.bee.services.find.busi.IFindBusiService;
import com.bee.services.find.impl.FindService;
import com.bee.services.shop.busi.IShopImageBusiService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/25.
 */
@Service
public class FindBusiService extends FindService implements IFindBusiService {

    @Autowired
    private FindImageDao findImageDao;

    /**
     * 保存发现
     *
     * @param param 发现实体
     */
    @Override
    @Transactional
    public void saveFind(FindSaveParam param) throws DataRunException {

        Find find = new Find();
        find.setType(Consts.Find.Type.ShopPop);
        find.setContent(param.getContent());
        find.setCreateTime(System.currentTimeMillis());
        find.setShop(new Shop(param.getShopId()));
        find.setUser(new User(param.getUid()));

        findDao.save(find);

        // 如果有附带图片
        // 目前仅支持商家相册中选择, 所以所有的ID, 均为ShopImage的ID
        if (!StringUtil.isNull(param.getImageIds())) {

            String[] idsStr = param.getImageIds().trim().split(",");

            if (idsStr.length < 1) {
                return;
            }
            if (idsStr.length == 0 && "".equals(idsStr[0].trim())) {
                return;
            }

            for (String id : idsStr) {
                FindImage findImage = new FindImage();
                findImage.setType(Consts.Find.Image.ShopImage);
                findImage.setFind(new Find(find.getFid()));
                findImage.setUrl("");
                findImage.setShopImage(new ShopImage(Long.valueOf(id)));
                findImageDao.save(findImage);
            }
        }
    }
}
