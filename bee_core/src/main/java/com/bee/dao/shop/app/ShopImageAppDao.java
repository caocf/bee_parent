package com.bee.dao.shop.app;

import com.bee.commons.SQL;
import com.bee.dao.shop.ShopImageDao;
import com.bee.domain.modal.app.shop.ShopImageItem;
import com.bee.domain.params.shop.ShopImageListParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Repository
public class ShopImageAppDao extends ShopImageDao {

    /**
     *
     * @param param
     * @return
     */
    public List<ShopImageItem> queryShopImage(ShopImageListParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Shop.Image.QueryShopImageApp);
        if (param != null) {
            if (param.getShopId() != null) {
                sb.append(" AND A.SHOP = ? ");
                entity.setParam(param.getShopId());
            }
            if (!StringUtil.isNull(param.getOrderBy())) {
                sb.append(" ORDER BY ");
                sb.append(param.getOrderBy());
            }
            if (param.getTop() != null) {
                sb.append(" LIMIT " + param.getTop());
            }
        }
        entity.setEntity(sb);
        entity.setQueryDataConver(QueryShopImage);
        return queryResultConver(entity);
    }
    public static final QueryDataConver<ShopImageItem> QueryShopImage = new QueryDataConver<ShopImageItem>() {
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
    };

}
