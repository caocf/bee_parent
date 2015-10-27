package com.bee.busi.controller;

import com.bee.busi.params.BusiInitRequest;
import com.bee.busi.params.BusiInitResponse;
import com.bee.client.params.AppVerResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopAttendService;
import com.bee.services.shop.IShopGroupService;
import com.bee.services.shop.IShopTecheeService;
import com.bee.services.system.IAppVerService;
import com.bee.services.user.IUserService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.security.encrypt.Md5;
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
    @Autowired
    private IShopGroupService shopGroupService;
    @Autowired
    private IShopTecheeService shopTecheeService;
    @Autowired
    private IShopAttendService shopAttendService;
    @Autowired
    private IUserService userService;


    /**
     * 商户端初始化方法
     * 主要用于同步数据
     *
     * 如果该方法访问出错，则会导致B端无法进入系统
     *
     * @param req BusiInitRequest
     * @return
     */
    @RequestMapping(value = "/busi/init", method = RequestMethod.GET)
    public BusiInitResponse init(BusiInitRequest req) {
        BusiInitResponse res = new BusiInitResponse();
        /**
         * 判断用户名密码是否正确
         * 兼容v1.0.0，如果有手机号和密码，则进行校验
         * 开始版本为v1.0.1
         */
        if (!StringUtil.isNull(req.getPhone(), req.getPassword())) {
            User user = userService.getUserByAccount(req.getPhone());
            if (null == user || user.getType() != Consts.User.Type.BusiUser) {
                res.setCode(Codes.User.LoginAccount);
                res.setMsg("登录账户不存在");
                return res;
            }
            // 登录成功
            if (!user.getPassword().equals(Md5.encodePassword(req.getPassword()))) {
                res.setCode(Codes.User.LoginPass);
                res.setMsg("密码错误");
                return res;
            }
        }
        // 发送服务器当前时间
        res.setCurrentTime(System.currentTimeMillis());
        // 同步商家群组
        res.setShopGroups(shopGroupService.getShopGroupByShopId(req.getSid()));
        // 同步商家技师
        res.setShopTechees(shopTecheeService.getShopTecheeByShopId(req.getSid()));
        // 同步商家出勤表
        res.setShopAttends(shopAttendService.getShopAttendByShopIdAfter(req.getSid(), res.getCurrentTime()));
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
