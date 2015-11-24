package com.bee.dao.shop.app;

import com.bee.commons.SQL;
import com.bee.dao.shop.ShopFocusDao;
import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.domain.type.ShopStatus;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/17.
 */
@Repository
public class ShopFocusAppDao extends ShopFocusDao {

    /**
     *
     *
     * @return
     */
    public PagingResult<ShopFavorite> getShopFocusListByParam(ShopFocusListParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Shop.Focus.GetShopFocusListByParam);
        if (param != null) {
            if (param.getUid() != null && param.getUid() > 0) {
                sb.append(" AND B.USER = ?");
                entity.setParam(param.getUid());
            }
            sb.append(" ORDER BY B.SFID DESC");
        }
        entity.setPaging(param);
        entity.setEntity(sb);
        entity.setQueryDataConver(new QueryDataConver<ShopFavorite>() {
            @Override
            public ShopFavorite converData(Object[] row) {
                ShopFavorite item = new ShopFavorite();
                item.setShopId(NumberUtil.parseLong(row[0], 0));
                item.setShopName(StringUtil.parseString(row[1], ""));
                item.setCreateTime(NumberUtil.parseLong(row[2], 0));
                item.setShopStatus(NumberUtil.parseInteger(row[3], ShopStatus.Stop.getStatus()));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }
}
