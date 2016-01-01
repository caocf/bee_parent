package com.bee.services.party.impl;

import com.bee.dao.party.PartyDao;
import com.bee.services.party.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/12/31.
 */
public abstract class PartyService implements IPartyService {

    @Autowired
    protected PartyDao partyDao;

}
