package com.bee.services.party;

import com.bee.pojo.party.PartyCondition;

/**
 * Created by suntongwei on 16/1/5.
 */
public interface IPartyConditionService {

    /**
     * 获取报名条件
     *
     * @param partyId
     * @return
     */
    PartyCondition getPartyCondition(Long partyId);


}
