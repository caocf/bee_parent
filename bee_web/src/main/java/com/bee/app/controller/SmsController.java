package com.bee.app.controller;

import com.bee.app.params.SMSResponse;
import com.bee.commons.Codes;
import com.bee.sms.SMSUtils;
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
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public SMSResponse sendRegisterSMS(String phone) {
        SMSResponse res = new SMSResponse();
        res.setSmsCode(SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.Register, phone));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 找回密码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/findpass", method = RequestMethod.GET)
    public SMSResponse sendFindPassSMS(String phone) {
        SMSResponse res = new SMSResponse();
        res.setSmsCode(SMSUtils.getInstance().sendSMS(SMSUtils.SMSType.FindPass, phone));
        res.setCode(Codes.Success);
        return res;
    }
}
