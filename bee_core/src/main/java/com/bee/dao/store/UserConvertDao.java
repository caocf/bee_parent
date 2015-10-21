package com.bee.dao.store;

import com.bee.app.model.store.UserConvertListItem;
import com.bee.app.params.store.UserConvertQueryRequest;
import com.bee.commons.SQL;
import com.bee.pojo.store.UserConvert;
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
public class UserConvertDao extends JpaDaoSupport<UserConvert, Long> {


    /**
     * 查询兑换记录
     *
     * @return
     */
    public PagingResult<UserConvertListItem> queryUserConverList(UserConvertQueryRequest req) {
        SQLEntity entity = new SQLEntity(SQL.Store.QueryUserConverList);
        entity.setParams(req.getUserId());
        entity.setPaging(req);
        entity.setQueryDataConver(new QueryDataConver<UserConvertListItem>() {
            @Override
            public UserConvertListItem converData(Object[] row) {
                UserConvertListItem item = new UserConvertListItem();
                item.setCardNumber(StringUtil.parseString(row[0], ""));
                item.setCreateTime(NumberUtil.parseLong(row[1], 0));
                item.setGoodsName(StringUtil.parseString(row[2], ""));
                item.setIntegral(NumberUtil.parseInteger(row[3], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

}
