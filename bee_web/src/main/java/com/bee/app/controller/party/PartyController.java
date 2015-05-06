package com.bee.app.controller.party;

import com.bee.modal.PartyListItem;
import com.bee.services.party.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<PartyListItem> getPartyList() {
        return partyService.getAppPartyList();
    }
}
