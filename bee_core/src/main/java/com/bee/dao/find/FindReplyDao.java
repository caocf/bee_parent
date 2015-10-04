package com.bee.dao.find;

import com.bee.client.params.find.FindReplyRequest;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.FindReplyItem;
import com.bee.pojo.find.FindReply;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/13.
 */
@Repository
public class FindReplyDao extends JpaDaoSupport<FindReply, Long> {


    /**
     *
     * @param req
     * @return
     */
    public PagingResult<FindReplyItem> getAppReplyList(FindReplyRequest req) {
        SQLEntity entity = new SQLEntity(SQL.Find.Reply.queryAppReplyList);
        entity.setParam(req.getFindId());
        entity.setPaging(req);
        entity.setQueryDataConver(new QueryDataConver<FindReplyItem>() {
            @Override
            public FindReplyItem converData(Object[] objs) {
                FindReplyItem item = new FindReplyItem();
                item.setFrid(NumberUtil.parseLong(objs[0], 0));
                item.setContent(StringUtil.parseString(objs[1], ""));
                item.setName(StringUtil.parseString(objs[2], ""));
                item.setUid(NumberUtil.parseLong(objs[3], 0));
                item.setCreateTime(NumberUtil.parseLong(objs[4], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }


}
