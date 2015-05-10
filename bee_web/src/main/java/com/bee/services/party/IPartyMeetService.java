package com.bee.services.party;

import com.bee.pojo.party.PartyMeet;

/**
 * Created by suntongwei on 15/5/10.
 */
public interface IPartyMeetService {

    /**
     *
     * @param pmid
     * @return
     */
    public PartyMeet getPartyMeetById(long pmid);
}
