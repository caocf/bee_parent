package com.bee.services.find.impl;

import com.bee.client.params.find.FindListRequest;
import com.bee.commons.Consts;
import com.bee.dao.find.FindDao;
import com.bee.dao.shop.ShopImageDao;
import com.bee.domain.modal.app.find.FindListItem;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/6/10.
 */
@Service
public class FindService implements IFindService {

    @Autowired
    private FindDao findDao;
    @Autowired
    private ShopImageDao shopImageDao;

    /**
     *
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<FindListItem> queryAppFindList(FindListRequest req) {
        PagingResult<FindListItem> items = findDao.queryAppFindList(req);
        if (null == items.getData() || items.getData().size() < 1) {
            return items;
        }
        /**
         * 遍历数据
         * 根据不同发现类型查询相应需要查询的图片或内容
         */
        for (FindListItem item : items.getData()) {
            switch (item.getType()) {
                case Consts.Find.Type.ShopNew:
                    item.setShopImages(shopImageDao.queryFindShopImage(item.getShopId()));
                    break;
                case Consts.Find.Type.ShopPop:
                    item.setShopImages(shopImageDao.queryFindShopImage(item.getShopId()));
                    break;
            }
        }
        return items;
    }
}
