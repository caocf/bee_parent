package com.bee.dao.shop.app;

import com.bee.commons.SQL;
import com.bee.dao.shop.ShopReplyDao;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/12/1.
 */
@Repository
public class ShopReplyAppDao extends ShopReplyDao {

    /**
     *
     * @param param
     * @return
     */
    public PagingResult<ShopReplyListItem> getReplyListForApp(ShopReplyListParam param) {
        SQLEntity entity = new SQLEntity(SQL.Shop.Reply.queryAppReplyList);
        entity.setParam(param.getCommentId());
        entity.setPaging(param);
        entity.setQueryDataConver(new QueryDataConver<ShopReplyListItem>() {
            @Override
            public ShopReplyListItem converData(Object[] objs) {
                ShopReplyListItem item = new ShopReplyListItem();
                item.setSrid(NumberUtil.parseLong(objs[0], 0));
                item.setContent(StringUtil.parseString(objs[1], ""));
                item.setName(StringUtil.parseString(objs[2], ""));
                item.setUid(NumberUtil.parseLong(objs[3], 0));
                item.setCreateTime(NumberUtil.parseLong(objs[4], 0));
                item.setLevel(NumberUtil.parseInteger(objs[5], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }
}
