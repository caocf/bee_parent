package com.bee.app.controller;

import com.bee.client.params.AppInitRequest;
import com.bee.client.params.AppInitResponse;
import com.bee.commons.Codes;
import com.bee.services.market.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/5/11.
 */
@RestController
public class AppController {

    @Autowired
    private IAdService adService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public AppInitResponse initAppInfo(AppInitRequest req) {
        AppInitResponse res = new AppInitResponse();
        // 更新广告
        // res.setNewAds(adService.getAppAdListByUpdateTime(req.getUpdateTime()));
        // 返回更新时间，防止手机时间错误
        res.setUpdateTime(req.getUpdateTime());
        res.setCode(Codes.Success);
        return res;
    }

}
