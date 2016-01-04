package com.bee.dao.party;

import com.bee.commons.SQL;
import com.bee.domain.params.party.PartyUserParam;
import com.bee.pojo.party.PartyUser;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 16/1/5.
 */
@Repository
public class PartyUserDao extends JpaDaoSupport<PartyUser, Long> {

    /**
     * 查询活动用户
     *
     * @param param
     * @return
     */
    public List<PartyUser> queryPartyUser(PartyUserParam param) {
        HQLEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Party.User.QueryPartyUser);
        if (param.getPartyId() != null && param.getPartyId() > 0) {
            sb.append(" AND B.pid = ?");
            entity.setParam(param.getPartyId());
        }
        if (param.getUserId() != null && param.getUserId() > 0) {
            sb.append(" AND C.uid = ?");
            entity.setParam(param.getUserId());
        }
        entity.setEntity(sb);
        return queryResult(entity);
    }

}
