package com.bee.dao.store;

import com.bee.app.model.store.GoodsListItem;
import com.bee.app.params.store.GoodsQueryRequest;
import com.bee.commons.SQL;
import com.bee.pojo.store.Goods;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/10/21.
 */
@Repository
public class GoodsDao extends JpaDaoSupport<Goods, Long> {

    /**
     * 查询商品列表
     *
     * @param request
     * @return
     */
    public PagingResult<GoodsListItem> queryGoodsList(GoodsQueryRequest request) {
        SQLEntity entity = new SQLEntity(SQL.Store.QueryGoodsList);
        entity.setPaging(request);
        entity.setQueryDataConver(new QueryDataConver<GoodsListItem>() {
            @Override
            public GoodsListItem converData(Object[] row) {
                GoodsListItem item = new GoodsListItem();
                item.setGid(NumberUtil.parseLong(row[0], 0));
                item.setName(StringUtil.parseString(row[1], ""));
                item.setIntegral(NumberUtil.parseInteger(row[2], 0));
                item.setNumber(NumberUtil.parseInteger(row[3], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }




}
