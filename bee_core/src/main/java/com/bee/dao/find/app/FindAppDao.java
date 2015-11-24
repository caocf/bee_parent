package com.bee.dao.find.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.find.FindDao;
import com.bee.domain.modal.app.find.Find;
import com.bee.domain.params.find.FindListParam;
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
public class FindAppDao extends FindDao {

    /**
     *
     * @param param
     * @return
     */
    public PagingResult<Find> queryFindListApp(FindListParam param) {
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
        entity.setQueryDataConver(new QueryDataConver<Find>() {
            @Override
            public Find converData(Object[] objs) {
                int i = 0;
                Find item = new Find();
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
