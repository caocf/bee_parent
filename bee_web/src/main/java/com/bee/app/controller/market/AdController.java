package com.bee.app.controller.market;

import com.bee.commons.Consts;
import com.bee.modal.AdListItem;
import com.bee.services.market.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@RestController
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private IAdService adService;

    /**
     *
     *
     * @param type
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<AdListItem> getAdList(Integer type) {
        return adService.getAppAdListByType(type != null ? type.intValue() : Consts.Ad.Type.Home);
    }

}
