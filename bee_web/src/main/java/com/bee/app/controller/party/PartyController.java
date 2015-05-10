package com.bee.app.controller.party;

import com.bee.client.params.party.PartyResponse;
import com.bee.commons.Consts;
import com.bee.modal.PartyListItem;
import com.bee.pojo.party.Party;
import com.bee.services.party.IPartyMeetService;
import com.bee.services.party.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/5/5.
 */
@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private IPartyService partyService;
    @Autowired
    private IPartyMeetService partyMeetService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PartyListItem> getPartyList() {
        return partyService.getAppPartyList();
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public PartyResponse getParty(@PathVariable Long pid) {
        PartyResponse res = new PartyResponse();
        Party party = partyService.getPartyById(pid);
        res.setParty(party);
        if(party.getType() == Consts.Party.Type.Offline) {
            res.setMeet(partyMeetService.getPartyMeetById(party.getChildId()));
        }
        return res;
    }
}
