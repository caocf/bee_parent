package com.bee.dao.find.app;

import com.bee.commons.SQL;
import com.bee.dao.find.FindImageDao;
import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.domain.params.find.FindImageParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/11/29.
 */
@Repository
public class FindImageAppDao extends FindImageDao {

    /**
     * 根据发现ID查询发现图片中的商家图片
     *
     * @param param
     * @return
     */
    public List<ShopImageItem> queryShopImageByFind(FindImageParam param) {
        SQLEntity entity = new SQLEntity(SQL.Find.Image.QueryShopImageByFind);
        entity.setParam(param.getFindId());
        entity.setQueryDataConver(new QueryDataConver<ShopImageItem>() {
            @Override
            public ShopImageItem converData(Object[] row) {
                ShopImageItem item = new ShopImageItem();
                item.setShopImageId(NumberUtil.parseLong(row[0], 0));
                item.setUrl(StringUtil.parseString(row[1], ""));
                item.setRemark(StringUtil.parseString(row[2], ""));
                item.setWidth(NumberUtil.parseInteger(row[3], 0));
                item.setHeight(NumberUtil.parseInteger(row[4], 0));
                return item;
            }
        });
        return queryResultConver(entity);
    }
}
