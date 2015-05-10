package com.bee.services.party.impl;

import com.bee.dao.party.PartyMeetDao;
import com.bee.pojo.party.PartyMeet;
import com.bee.services.party.IPartyMeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/5/10.
 */
@Service
public class PartyMeetService implements IPartyMeetService {

    @Autowired
    private PartyMeetDao partyMeetDao;

    @Override
    public PartyMeet getPartyMeetById(long pmid) {
        return partyMeetDao.findById(pmid);
    }
}
