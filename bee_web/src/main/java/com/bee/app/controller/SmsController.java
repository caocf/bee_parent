package com.bee.app.controller;

import com.bee.app.commons.AppConsts;
import com.bee.app.params.SMSResponse;
import com.bee.commons.Codes;
import com.bee.sms.SMSUtils;
import com.qsd.framework.commons.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/20.
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    /**
     * 注册发送验证短信
     *
     * @deprecated C端从v1.0.5开始，将启用新的v1接口
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public SMSResponse sendRegisterSMS(String phone) {
        SMSResponse res = new SMSResponse();
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
        if (!AppConsts.isDebug) {
            res.setSmsCode(SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.Register, phone));
        } else {
            res.setSmsCode("0000");
        }
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 找回密码
     *
     * @deprecated 从C端v1.0.5开始将启用新的v1接口
     * @param phone
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/findpass", method = RequestMethod.GET)
    public SMSResponse sendFindPassSMS(String phone) {
        SMSResponse res = new SMSResponse();
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
        res.setSmsCode(SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.FindPass, phone));
        res.setCode(Codes.Success);
        return res;
    }


}
