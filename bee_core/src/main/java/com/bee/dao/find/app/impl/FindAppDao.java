package com.bee.dao.find.app.impl;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.find.app.IFindAppDao;
import com.bee.dao.find.impl.FindDao;
import com.bee.domain.params.FindListParam;
import com.bee.modal.FindListItem;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/15.
 */
@Repository
public class FindAppDao extends FindDao implements IFindAppDao {

    /**
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<FindListItem> queryFindList(FindListParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Find.QueryFindAppList);
        if (param != null) {
            if (param.getLastRefreshTime() != null) {
                sb.append(" A.CREATETIME > ?");
                entity.setParam(param.getLastRefreshTime());
            }
            // 根据ID降序排序
            sb.append(" ORDER BY A.FID DESC");
        }
        if (param.isPaging()) {
            entity.setPaging(param);
        }
        entity.setEntity(sb);
        entity.setQueryDataConver(new QueryDataConver<FindListItem>() {
            @Override
            public FindListItem converData(Object[] objs) {
                int i = 0;
                FindListItem item = new FindListItem();
                item.setFindId(NumberUtil.parseLong(objs[i++], 0));
                item.setUserId(NumberUtil.parseLong(objs[i++], 0));
                item.setType(NumberUtil.parseInteger(objs[i++], Consts.Find.Type.Unknow));
                item.setName(StringUtil.parseString(objs[i++], "游客"));
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
