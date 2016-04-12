package com.bee.busi.controller;

import com.bee.busi.params.BusiInitRequest;
import com.bee.busi.params.BusiInitResponse;
import com.bee.client.params.AppVerResponse;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.pojo.shop.ShopUpdate;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopUpdateService;
import com.bee.services.shop.busi.IShopAttendBusiService;
import com.bee.services.shop.busi.IShopGroupBusiService;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.bee.services.system.IAppVerService;
import com.bee.services.system.busi.IAppVerBusiService;
import com.bee.services.user.IUserService;
import com.bee.services.user.busi.IUserBusiService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.security.encrypt.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/15.
 */
@RestController
public class AppController {

    @Autowired
    private IAppVerBusiService appVerBusiService;

    // v1.1 删除
//    @Autowired
//    private IShopGroupBusiService shopGroupBusiService;
//    @Autowired
//    private IShopAttendBusiService shopAttendBusiService;

    @Autowired
    private IShopTecheeBusiService shopTecheeBusiService;

    @Autowired
    private IUserBusiService userBusiService;
    @Autowired
    private IShopUpdateService shopUpdateService;

    /**
     * 商户端初始化方法
     * 主要用于同步数据
     *
     * 如果该方法访问出错，则会导致B端无法进入系统
     *
     * @param req BusiInitRequest
     * @return
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public BusiInitResponse init(BusiInitRequest req) {
        BusiInitResponse res = new BusiInitResponse();
        /**
         * 判断用户名密码是否正确
         * 兼容v1.0.0，如果有手机号和密码，则进行校验
         * 开始版本为v1.0.1
         */
        if (!StringUtil.isNull(req.getPhone(), req.getPassword())) {
            User user = userBusiService.getUserByAccount(req.getPhone());
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

        /***********************************************************************************
         * v1.1.0 删除以下部分
         */
        // 是否需要同步技师数据
//        ShopUpdate shopUpdate = shopUpdateService.getShopUpdateByShopId(req.getSid());
//        if (req.getUpdateTechee() != null
//                && shopUpdate.getUpdateTechee() > req.getUpdateTechee()) {
//            res.setTecheeUpdate(shopUpdate.getUpdateTechee());
//            res.setShopTechees(shopTecheeBusiService.getShopTecheeByShopId(req.getSid()));
//        }
        /************************************************************************************/

        // v1.1 删除
        // 同步商家群组
//        res.setShopGroups(shopGroupBusiService.getShopGroupByShopId(req.getSid()));
        // 同步商家技师
//        res.setShopTechees(shopTecheeBusiService.getShopTecheeByShopId(req.getSid()));
        // 同步商家出勤表
//        res.setShopAttends(shopAttendBusiService.getShopAttendByShopIdAfter(req.getSid(), res.getCurrentTime()));
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
        AppVer appVer = appVerBusiService.getNewAppVer();
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
