package com.bee.busi.controller;

import com.bee.client.params.AppVerResponse;
import com.bee.commons.Codes;
import com.bee.pojo.AppVer;
import com.bee.services.system.IAppVerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/6.
 */
@RestController
public class BusiAppController {

    @Autowired
    private IAppVerService appVerService;

    /**
     * 检查版本
     *
     * @param phoneType
     * @param ver
     * @return
     */
    @RequestMapping(value = "/busi/check/ver", method = RequestMethod.GET)
    public AppVerResponse checkAppVer(Integer phoneType, Integer ver) {
        AppVerResponse res = new AppVerResponse();
        AppVer appVer = appVerService.getNewAppVer(phoneType);
        if (appVer != null && appVer.getVer() > ver) {
            res.setCode(Codes.Success);
            res.setRemark(appVer.getRemark());
            res.setUrl(appVer.getUrl());
            res.setVersion(appVer.getVerStr());
        } else {
            res.setCode(Codes.Error);
        }
        return res;
    }

}
