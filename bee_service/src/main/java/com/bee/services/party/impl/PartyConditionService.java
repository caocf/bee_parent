package com.bee.services.party.impl;

import com.bee.dao.party.PartyConditionDao;
import com.bee.pojo.party.PartyCondition;
import com.bee.services.party.IPartyConditionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/1/5.
 */
public abstract class PartyConditionService implements IPartyConditionService {

    @Autowired
    protected PartyConditionDao partyConditionDao;

    /**
     * 获取报名条件
     *
     * @param partyId
     * @return
     */
    @Override
    public PartyCondition getPartyCondition(Long partyId) {
        return partyConditionDao.getPartyCondition(partyId);
    }
}
