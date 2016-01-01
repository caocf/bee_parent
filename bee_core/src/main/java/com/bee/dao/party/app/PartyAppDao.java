package com.bee.dao.party.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.party.PartyDao;
import com.bee.domain.modal.app.party.PartyList;
import com.bee.domain.params.party.PartyListParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/12/31.
 */
@Repository
public class PartyAppDao extends PartyDao {

    /**
     * 获取活动列表
     *
     * @param param
     * @return
     */
    public PagingResult<PartyList> getPartyList(PartyListParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Party.GetPartyList);
        entity.setPaging(param);
        sb.append(SQL.Party.GetPartyListOrderBy);
        entity.setEntity(sb);
        entity.setQueryDataConver(new QueryDataConver<PartyList>() {

            private Long curTime = System.currentTimeMillis();

            @Override
            public PartyList converData(Object[] row) {
                // A.PID, A.TYPE, A.PARTYTIME, A.STARTTIME, A.STOPTIME, A.ISBEE, A.TITLE, A.CONTENT
                PartyList item = new PartyList();
                item.setPid(NumberUtil.parseLong(row[0], 0));
                item.setType(NumberUtil.parseInteger(row[1], Consts.Party.Type.Online));
                item.setPartyTime(StringUtil.parseString(row[2], ""));
                long startTime = NumberUtil.parseLong(row[3], 0);
                item.setStartTime(startTime);
                long stopTime = NumberUtil.parseLong(row[4], 0);
                item.setStopTime(stopTime);
                item.setIsBee(NumberUtil.parseInteger(row[5], Consts.False));
                item.setTitle(StringUtil.parseString(row[6], ""));
                item.setContent(StringUtil.parseString(row[7], ""));
                if (curTime < startTime) {
                    item.setStatus(Consts.Party.Status.Create);
                } else if (curTime > startTime && curTime < stopTime) {
                    item.setStatus(Consts.Party.Status.Ing);
                } else {
                    item.setStatus(Consts.Party.Status.Finish);
                }
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

}
