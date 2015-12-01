package com.bee.services.find.app.impl;

import com.bee.commons.Consts;
import com.bee.dao.find.FindImageDao;
import com.bee.dao.find.app.FindAppDao;
import com.bee.dao.find.app.FindImageAppDao;
import com.bee.dao.shop.app.ShopImageAppDao;
import com.bee.domain.modal.app.find.FindListItem;
import com.bee.domain.params.find.FindImageParam;
import com.bee.domain.params.find.FindListParam;
import com.bee.domain.params.find.FindSaveParam;
import com.bee.domain.params.shop.ShopImageListParam;
import com.bee.services.find.app.IFindAppService;
import com.bee.services.find.impl.FindService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class FindAppService extends FindService implements IFindAppService {

    @Autowired
    private FindAppDao findAppDao;
    @Autowired
    private ShopImageAppDao shopImageAppDao;
    @Autowired
    private FindImageAppDao findImageAppDao;

    /**
     * @see com.bee.services.find.app.IFindAppService#queryFindList
     * @param param 查询参数
     * @return PagingResult<FindListItem>
     */
    @Override
    public PagingResult<FindListItem> queryFindList(FindListParam param) {
        PagingResult<FindListItem> items = findAppDao.queryFindListApp(param);
        if (null == items.getData() || items.getData().size() < 1) {
            return items;
        }
        /**
         * 根据不同发现类型查询相应需要查询的图片或内容
         */
        ShopImageListParam shopImageParam = new ShopImageListParam();
        shopImageParam.setTop(9);
        shopImageParam.setOrderBy(" A.SORT DESC ");

        /**
         * 发现图片查询
         */
        FindImageParam findImageParam = new FindImageParam();

        /**
         * 遍历数据
         */
        for (FindListItem item : items.getData()) {
            switch (item.getType()) {
                case Consts.Find.Type.ShopNew:
                    shopImageParam.setShopId(item.getShopId());
                    item.setShopImages(shopImageAppDao.queryShopImage(shopImageParam));
                    break;
                case Consts.Find.Type.ShopPop:
                    findImageParam.setFindId(item.getFindId());
                    item.setShopImages(findImageAppDao.queryShopImageByFind(findImageParam));
                    break;
            }
        }
        return items;
    }

    /**
     * 保存发现
     *
     * @param param 发现实体
     */
    @Override
    @Transactional
    public void saveFind(FindSaveParam param) throws DataRunException {
        // C端不实现
    }
}
