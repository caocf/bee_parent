package com.bee.client.params.party;

import com.bee.pojo.party.Party;
import com.bee.pojo.party.PartyMeet;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/5/10.
 */
public class PartyResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -3965975425966132826L;

    private Party party;
    private PartyMeet meet;


    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public PartyMeet getMeet() {
        return meet;
    }

    public void setMeet(PartyMeet meet) {
        this.meet = meet;
    }
}
