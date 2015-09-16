package com.bee.dao.find;

import com.bee.client.params.find.FindListRequest;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.FindListItem;
import com.bee.pojo.find.Find;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/10.
 */
@Repository
public class FindDao extends JpaDaoSupport<Find, Long> {

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<FindListItem> queryAppFindList(FindListRequest req) {
        SQLEntity entity = new SQLEntity(SQL.Find.queryAppFindList);
        entity.setPaging(req);
        entity.setQueryDataConver(new QueryDataConver<FindListItem>() {
            @Override
            public FindListItem converData(Object[] objs) {
                FindListItem item = new FindListItem();
                item.setFindId(NumberUtil.parseLong(objs[0], 0));
                item.setUserId(NumberUtil.parseLong(objs[1], 0));
                item.setName(StringUtil.parseString(objs[2], "游客"));
                item.setAvatar(new ImageFactory.Image(
                        StringUtil.parseString(objs[3], null), ImageFactory.ImageType.UserImage
                ));
                item.setCreateTime(NumberUtil.parseLong(objs[4], 0));
                item.setContent(StringUtil.parseString(objs[5], ""));
                item.setShopId(NumberUtil.parseLong(objs[6], 0));
                item.setShopName(StringUtil.parseString(objs[7], ""));
                item.setReplyNum(NumberUtil.parseInteger(objs[8], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

}
