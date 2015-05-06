package com.bee.client.params.party;

import com.bee.pojo.party.Party;
import com.bee.pojo.party.PartyMeet;
import com.qsd.framework.spring.BaseRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by suntongwei on 15/5/6.
 */
public class AdminPartyRequest extends BaseRequest {

    // serialVersionUID
    private static final long serialVersionUID = -271399252522189278L;

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