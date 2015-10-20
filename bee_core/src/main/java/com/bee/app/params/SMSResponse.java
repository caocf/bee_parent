package com.bee.app.params;

import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/10/20.
 */
public class SMSResponse extends BaseResponse {

    private static final long serialVersionUID = -1691258214935501072L;

    /**
     * 短信验证码
     */
    private String smsCode;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
