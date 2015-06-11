package com.bee.dao.shop;

import com.bee.client.params.shop.ShopReplyRequest;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.ShopReplyListItem;
import com.bee.pojo.shop.ShopReply;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/11.
 */
@Repository
public class ShopReplyDao extends JpaDaoSupport<ShopReply, Long> {

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<ShopReplyListItem> getAppReplyList(ShopReplyRequest req) {
        SQLEntity entity = new SQLEntity(SQL.Shop.Reply.queryAppReplyList);
        entity.setParam(req.getCommentId());
        entity.setPaging(req);
        entity.setQueryDataConver(new QueryDataConver<ShopReplyListItem>() {
            @Override
            public ShopReplyListItem converData(Object[] objs) {
                ShopReplyListItem item = new ShopReplyListItem();
                item.setSrid(NumberUtil.parseLong(objs[0], 0));
                item.setContent(StringUtil.parseString(objs[1], ""));
                item.setName(StringUtil.parseString(objs[2], ""));
                item.setAvatar(new ImageFactory.Image(
                        StringUtil.parseString(objs[3], null), ImageFactory.ImageType.UserImage
                ));
                item.setCreateTime(NumberUtil.parseLong(objs[4], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }


}
