package com.bee.admin.controller.party;

import com.bee.client.params.party.AdminPartyRequest;
import com.bee.services.party.IPartyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/4/27.
 */
@Controller
@RequestMapping("/admin/party")
public class AdminPartyController {

    @Autowired
    private IPartyService partyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("market/PartyList");
        mav.addObject("PartyList", partyService.getPartyList());
        return mav;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("market/PartyNew");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(AdminPartyRequest req, HttpServletRequest request,
                             @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            partyService.save(req, request, file);
            return index();
        } catch (DataRunException e) {
            e.printStackTrace();
            return create();
        }
    }
}
