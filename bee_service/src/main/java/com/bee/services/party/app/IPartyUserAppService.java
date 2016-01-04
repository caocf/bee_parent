package com.bee.services.party.app;

import com.bee.pojo.party.PartyUser;
import com.bee.services.party.IPartyUserService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 16/1/5.
 */
public interface IPartyUserAppService extends IPartyUserService {

    /**
     * 参加活动
     *
     * @param partyUser
     * @throws DataRunException
     */
    void addParty(PartyUser partyUser) throws DataRunException;
}
