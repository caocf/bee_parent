package com.bee.app.controller;

import com.bee.client.params.AppInitRequest;
import com.bee.client.params.AppInitResponse;
import com.bee.client.params.AppVerResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.pojo.Applyer;
import com.bee.services.market.IAdService;
import com.bee.services.stat.IUserStatService;
import com.bee.services.system.IAppVerService;
import com.bee.services.system.IApplyerService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
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
    @Autowired
    private IUserStatService userStatService;
    @Autowired
    private IAppVerService appVerService;
    @Autowired
    private IApplyerService applyerService;

    /**
     * 初始化
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public AppInitResponse initAppInfo(AppInitRequest req) {
        AppInitResponse res = new AppInitResponse();

        // 更新用户登录
        if (!Consts.isDebug) {
            userStatService.addUserLoginStat(
                    req.getUid() != null && req.getUid() > 0 ?
                            req.getUid() : 0, req.getDevice());
        }


        // 客服电话
        res.setServicePhone(Consts.Config.ServicePhone);

        // 更新广告
        // res.setNewAds(adService.getAppAdListByUpdateTime(req.getUpdateTime()));
        // 返回更新时间，防止手机时间错误
        res.setUpdateTime(req.getUpdateTime());
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 检查版本
     *
     * @param phoneType
     * @param ver
     * @return
     */
    @RequestMapping(value = "/check/ver", method = RequestMethod.GET)
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

    /**
     *
     * @param applyer
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public BaseResponse shopApply(Applyer applyer) {
        BaseResponse res = new BaseResponse();
        if (StringUtil.checkIllegalChar(applyer.getExtraInfo(), applyer.getPhone(), applyer.getLinkName())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容不合法，请重新输入");
            return res;
        }
        try {
            applyerService.addApplyer(applyer);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }

}
