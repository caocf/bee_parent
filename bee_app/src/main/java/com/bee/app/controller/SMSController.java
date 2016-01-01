package com.bee.app.controller;

import com.bee.app.commons.AppConsts;
import com.bee.commons.Codes;
import com.bee.sms.SMSCodeFactory;
import com.bee.sms.SMSUtils;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/16.
 */
@RestController
@RequestMapping("/v1/sms")
public class SMSController {

    /**
     * 注册发送验证短信
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public Response sendRegisterSMS(String phone) {
        Response res = new Response();
        if (StringUtil.isNull(phone)) {
            res.setCode(Codes.Error);
            res.setMsg("未知手机号");
            return res;
        }
        if (phone.length() != 11) {
            res.setCode(Codes.Error);
            res.setMsg("未知手机号");
            return res;
        }
        String code;
        if (!AppConsts.isDebug) {
            code = SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.Register, phone);
        } else {
            code = "1234";
        }
        SMSCodeFactory.getInstance().putCode(code, phone);
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 找回密码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/pass/find", method = RequestMethod.GET)
    public Response sendFindPassSMS(String phone) {
        Response res = new Response();
        if (StringUtil.isNull(phone)) {
            res.setCode(Codes.Error);
            res.setMsg("未知手机号");
            return res;
        }
        if (phone.length() != 11) {
            res.setCode(Codes.Error);
            res.setMsg("未知手机号");
            return res;
        }
        String code;
        if (!AppConsts.isDebug) {
            code = SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.FindPass, phone);
        } else {
            code = "1234";
        }
        SMSCodeFactory.getInstance().putCode(code, phone);
        res.setCode(Codes.Success);
        return res;
    }

    /**
     *
     *
     * @param code
     * @return
     */
    @RequestMapping("/code")
    public Response equalCode(String phone, String code) {
        Response res = new Response();
        if (StringUtil.isNull(code)) {
            res.setCode(Codes.Error);
            res.setMsg("参数错误");
            return res;
        }
        // 验证code是否正确
        String mCode = SMSCodeFactory.getInstance().getCode(phone);
        if (null == mCode || !code.equals(mCode)) {
            res.setCode(Codes.Error);
            res.setMsg("验证码过期");
            return res;
        }
        res.setCode(Codes.Success);
        return res;
    }

}
