package com.bee.dao.party;

import com.bee.commons.SQL;
import com.bee.pojo.party.PartyCondition;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 16/1/5.
 */
@Repository
public class PartyConditionDao extends JpaDaoSupport<PartyCondition, Long> {

    /**
     * 获取报名条件
     *
     * @param partyId
     * @return
     */
    public PartyCondition getPartyCondition(Long partyId) {
        return findFirstByParams(SQL.Party.Condition.GetCondition, partyId);
    }
}
