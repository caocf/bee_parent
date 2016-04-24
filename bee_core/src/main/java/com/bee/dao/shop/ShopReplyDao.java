package com.bee.dao.shop;

import com.bee.admin.params.shop.AdminShopReplyRequest;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.shop.ShopReply;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/11.
 */
@Repository
public class ShopReplyDao extends JpaDaoSupport<ShopReply, Long> {

    public static final String QueryShopReplyList = "From ShopReply A " +
            " left join fetch A.user B where 1=1 ";

    /**
     * 查询评论回复列表
     *
     * @param params
     * @return
     */
    public PagingResult<ShopReply> queryShopReplyList(AdminShopReplyRequest params) {
        HQLEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(QueryShopReplyList);
        if (params.getCommentId() != null && params.getCommentId() > 0) {
            sb.append(" and A.shopComment.scid = ?");
            entity.setParam(params.getCommentId());
        }
        entity.setPaging(params);
        sb.append(" order by A.srid desc");
        entity.setEntity(sb.toString());
        return queryWithPaging(entity);
    }


}
