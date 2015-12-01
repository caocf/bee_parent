package com.bee.dao.find.app;

import com.bee.commons.SQL;
import com.bee.dao.find.FindReplyDao;
import com.bee.domain.modal.app.find.FindReplyItem;
import com.bee.domain.params.find.FindReplyParam;
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
public class FindReplyAppDao extends FindReplyDao {

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<FindReplyItem> getReplyListForApp(FindReplyParam req) {
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
                item.setLevel(NumberUtil.parseInteger(objs[5], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }
}
