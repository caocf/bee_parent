package com.bee.app.controller;

import com.bee.app.commons.AppConsts;
import com.bee.app.commons.SystemConfigFactory;
import com.bee.client.params.AppInitRequest;
import com.bee.client.params.AppInitResponse;
import com.bee.client.params.AppVerResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.AppVer;
import com.bee.pojo.Area;
import com.bee.pojo.SystemConfig;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.app.IUserStatAppService;
import com.bee.services.system.IAreaService;
import com.bee.services.system.ISystemConfigService;
import com.bee.services.system.app.IAppVerAppService;
import com.bee.services.system.app.IAreaAppService;
import com.bee.services.user.app.IMessageAppService;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/11/24.
 */
@RestController
@RequestMapping("/v1")
public class AppController {

    @Autowired
    private IUserStatAppService userStatAppService;
    @Autowired
    private IAreaAppService areaAppService;
    @Autowired
    private ISystemConfigService systemConfigService;
    @Autowired
    private IAppVerAppService appVerAppService;
    @Autowired
    private IMessageAppService messageAppService;

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
        if (!AppConsts.isDebug) {
            UserLoginStat userLoginStat = new UserLoginStat();
            userLoginStat.setAppVer(req.getVersion());
            userLoginStat.setDevice(req.getDevice());
            userLoginStat.setPhoneType(req.getPhoneType());
            userLoginStat.setUser(new User(
                    req.getUid() != null && req.getUid() > 0 ? req.getUid() : 0));
            userStatAppService.addUserLoginStat(userLoginStat);
        }

        // 判断用户登录信息
        // v1.1.0 增加
        if (req.getVersion() >= 7) {

        }

        // iPhone是否已经过了审核
        res.setIntoApp(false);

        // 客服电话
        res.setServicePhone(Consts.Config.ServicePhone);
        // 更新广告
        // res.setNewAds(adService.getAppAdListByUpdateTime(req.getUpdateTime()));
        // 返回更新时间，防止手机时间错误
        res.setUpdateTime(req.getUpdateTime());
        res.setServerStatus(AppConsts.Normal);

        // 检查地区
        res.setAreaList(checkAreaVer(req.getAreaLastId()));

        // 增加首页和发现广告图更新时间
        SystemConfigFactory factory = SystemConfigFactory.getInstance();
        res.setMainAdUpdateTime(factory.getConfig(Consts.Config.MainAd).getFlag());
        res.setFindAdUpdateTime(factory.getConfig(Consts.Config.FindAd).getFlag());
        res.setQrImageUpdateTime(factory.getConfig(Consts.Config.Qr).getFlag());

        // v1.1.0 增加用户新消息
        if (req.getUid() != null && req.getUid() > 0) {
            MessageParam param = new MessageParam();
            param.setUid(req.getUid());
            param.setStatus(Consts.User.Message.Status.UnRead);
            List<MessageList> messages = messageAppService.getUserMessage(param);
            res.setNewMessageNum(null == messages || messages.size() < 1 ? 0 : messages.size());
        }

        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 检查地区
     *
     * @param lastId
     * @return
     */
    private List<Area> checkAreaVer(Long lastId) {
        if (null == lastId) {
            return null;
        }
        SystemConfig config = SystemConfigFactory.getInstance().getConfig(Consts.Config.Area);
        // 如果客户端发送updateTime == 0,则拉取数据
        // 如果客户端版本低于系统配置版本也拉取数据
        if ((config != null && config.getFlag() > lastId) || lastId == 0) {
            return areaAppService.getAreaByLastId(lastId);
        }
        return null;
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/order/time", method = RequestMethod.GET)
    public ResponseArray<Long> getOrderTime(Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        ResponseArray<Long> res = new ResponseArray<>();
        res.setResult(new ArrayList<Long>());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        int minute = cal.get(Calendar.MINUTE);
        if (minute >= 45) {
            cal.add(Calendar.HOUR_OF_DAY, 1);
            cal.set(Calendar.MINUTE, 0);
        } else if (minute >= 30 && minute < 45) {
            cal.set(Calendar.MINUTE, 45);
        } else if (minute >= 15 && minute < 30) {
            cal.set(Calendar.MINUTE, 30);
        } else if (minute >=0 && minute < 15) {
            cal.set(Calendar.MINUTE, 15);
        }

        // 开始时间
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.AM_PM, startHour > 12 ? Calendar.PM : Calendar.AM);
        startTime.set(Calendar.HOUR_OF_DAY, startHour);
        startTime.set(Calendar.HOUR, startHour > 12 ? startHour - 12 : startHour);
        startTime.set(Calendar.MINUTE, startMinute);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);

        // 结束时间
        Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.AM_PM, endHour > 12 ? Calendar.PM : Calendar.AM);
        endTime.set(Calendar.HOUR_OF_DAY, endHour);
        endTime.set(Calendar.HOUR, endHour > 12 ? endHour - 12 : endHour);
        endTime.set(Calendar.MINUTE, endMinute);
        endTime.set(Calendar.SECOND, 0);
        endTime.set(Calendar.MILLISECOND, 0);

        if (cal.getTimeInMillis() < startTime.getTimeInMillis()
                && cal.getTimeInMillis() < endTime.getTimeInMillis()) {
            startTime.add(Calendar.DAY_OF_MONTH, -1);
        } else {
            endTime.add(Calendar.DAY_OF_MONTH, 1);
        }

        while (cal.getTimeInMillis() <= endTime.getTimeInMillis()) {
            if (cal.getTimeInMillis() < startTime.getTimeInMillis()) {
                cal.add(Calendar.MINUTE, 15);
                continue;
            }
            res.getResult().add(cal.getTimeInMillis());
            cal.add(Calendar.MINUTE, 15);
        }
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
        AppVer appVer = appVerAppService.getNewAppVer();
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
