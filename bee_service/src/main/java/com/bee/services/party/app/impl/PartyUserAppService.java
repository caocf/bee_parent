package com.bee.services.party.app.impl;

import com.bee.pojo.party.PartyUser;
import com.bee.services.party.app.IPartyUserAppService;
import com.bee.services.party.impl.PartyUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 16/1/5.
 */
@Service
public class PartyUserAppService extends PartyUserService implements IPartyUserAppService {

    /**
     * 参加活动
     *
     * @param partyUser
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void addParty(PartyUser partyUser) throws DataRunException {
        partyUser.setCreateTime(System.currentTimeMillis());
        partyUserDao.save(partyUser);
    }
}
