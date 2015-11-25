package com.bee.services.find.app.impl;

import com.bee.commons.Consts;
import com.bee.dao.find.app.FindAppDao;
import com.bee.dao.shop.app.ShopImageAppDao;
import com.bee.domain.modal.app.find.Find;
import com.bee.domain.params.find.FindListParam;
import com.bee.domain.params.shop.ShopImageListParam;
import com.bee.modal.FindListItem;
import com.bee.services.find.app.IFindAppService;
import com.bee.services.find.impl.FindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class FindAppService extends FindService implements IFindAppService {

    @Autowired
    private FindAppDao findAppDao;
    @Autowired
    private ShopImageAppDao shopImageAppDao;

    /**
     * @see com.bee.services.find.app.IFindAppService#queryFindList
     * @param param 查询参数
     * @return PagingResult<Find>
     */
    @Override
    public PagingResult<Find> queryFindList(FindListParam param) {
        PagingResult<Find> items = findAppDao.queryFindListApp(param);
        if (null == items.getData() || items.getData().size() < 1) {
            return items;
        }
        /**
         * 遍历数据
         * 根据不同发现类型查询相应需要查询的图片或内容
         */
        ShopImageListParam shopImageParam = new ShopImageListParam();
        shopImageParam.setTop(9);
        shopImageParam.setOrderBy(" A.SORT DESC ");
        for (Find item : items.getData()) {
            shopImageParam.setShopId(item.getShopId());
            switch (item.getType()) {
                case Consts.Find.Type.ShopNew:
                    item.setShopImages(shopImageAppDao.queryShopImage(shopImageParam));
                    break;
                case Consts.Find.Type.ShopPop:
                    item.setShopImages(shopImageAppDao.queryShopImage(shopImageParam));
                    break;
            }
        }
        return items;
    }

    /**
     * 保存发现
     *
     * @param find 发现实体
     */
    @Override
    public void saveFind(com.bee.pojo.find.Find find) {
        // C端不实现
    }
}
