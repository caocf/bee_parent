package com.bee.services.party.impl;

import com.bee.dao.party.PartyUserDao;
import com.bee.domain.params.party.PartyUserParam;
import com.bee.pojo.party.PartyUser;
import com.bee.services.party.IPartyUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by suntongwei on 16/1/5.
 */
public abstract class PartyUserService implements IPartyUserService {

    @Autowired
    protected PartyUserDao partyUserDao;

    /**
     * 查询活动用户
     *
     * @param param
     * @return
     */
    @Override
    public List<PartyUser> queryPartyUser(PartyUserParam param) {
        return partyUserDao.queryPartyUser(param);
    }
}
