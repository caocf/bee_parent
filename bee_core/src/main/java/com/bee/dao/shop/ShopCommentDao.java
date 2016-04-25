package com.bee.dao.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.commons.SQL;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.shop.ShopComment;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/3.
 */
@Repository
public class ShopCommentDao extends JpaDaoSupport<ShopComment, Long> {

    /**
     *
     * @param request
     * @return
     */
    public PagingResult<ShopCommentListItem> queryAppShopComment(ShopCommentRequest request) {
        SQLEntity entity = new SQLEntity(SQL.Shop.Comment.getAppCommentList);
        entity.setParam(request.getShopId());
        entity.setPaging(request);
        entity.setQueryDataConver(QueryAppShopCommentConver);
        return queryWithPagingConver(entity);
    }
    public static final QueryDataConver<ShopCommentListItem> QueryAppShopCommentConver =
            new QueryDataConver<ShopCommentListItem>() {
                @Override
                public ShopCommentListItem converData(Object[] objs) {
                    ShopCommentListItem item = new ShopCommentListItem();
                    item.setScid(NumberUtil.parseLong(objs[0], 0));
                    item.setContent(StringUtil.parseString(objs[1], ""));
                    item.setCreateTime(NumberUtil.parseLong(objs[2], 0));
                    item.setUid(NumberUtil.parseLong(objs[3], 0));
                    item.setName(StringUtil.parseString(objs[4], ""));
                    item.setShopId(NumberUtil.parseLong(objs[5], 0));
                    item.setReplyNum(NumberUtil.parseLong(objs[6], 0));
                    item.setLevel(NumberUtil.parseInteger(objs[7], 0));
                    return item;
                }
            };

    /**
     *
     * @param request
     * @return
     */
    public static final String QueryShopComment = "From ShopComment A " +
            "left join fetch A.user B " +
            "left join fetch A.shop C " +
            "where 1=1 ";
    public PagingResult<ShopComment> queryShopComment(AdminShopCommentRequest request) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(QueryShopComment);
        if (request.getShopId() != null && request.getShopId() > 0) {
            sb.append(" and A.shop.sid = ?");
            entity.setParam(request.getShopId());
        }
        entity.setPaging(request);
        sb.append(SQL.Shop.Comment.QueryShopCommentOrderBy);
        entity.setEntity(sb.toString());
        return queryWithPaging(entity);
    }

}
