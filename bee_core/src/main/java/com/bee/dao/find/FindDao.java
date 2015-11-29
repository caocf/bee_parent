package com.bee.dao.find;

import com.bee.client.params.find.FindListRequest;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.domain.modal.app.find.FindListItem;
import com.bee.pojo.find.Find;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/15.
 */
@Repository
public class FindDao extends JpaDaoSupport<Find, Long> {


    /**
     * 查询发现列表(C端)
     *
     * 2015.9.17
     * 更改用户头像获取方式
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
                int i = 0;
                FindListItem item = new FindListItem();
                item.setFindId(NumberUtil.parseLong(objs[i++], 0));
                item.setUserId(NumberUtil.parseLong(objs[i++], 0));
                item.setType(NumberUtil.parseInteger(objs[i++], Consts.Find.Type.Unknow));
                item.setName(StringUtil.parseString(objs[i++], "游客"));
//                item.setAvatar(new ImageFactory.Image(
//                        StringUtil.parseString(objs[3], null), ImageFactory.ImageType.UserImage
//                ));
                item.setCreateTime(NumberUtil.parseLong(objs[i++], 0));
                item.setContent(StringUtil.parseString(objs[i++], ""));
                item.setShopId(NumberUtil.parseLong(objs[i++], 0));
                item.setShopName(StringUtil.parseString(objs[i++], ""));
                item.setReplyNum(NumberUtil.parseInteger(objs[i++], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

}
