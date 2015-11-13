package com.bee.sms;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.Map;

/**
 * Created by suntongwei on 15/10/20.
 */
public class SMSUtils {

    private static SMSUtils ourInstance = new SMSUtils();

    /**
     * 融信通IP地址
     */
    public static final String Address = "app.cloopen.com";

    /**
     * 融信通Port
     */
    public static final String Port = "8883";

    /**
     * SID
     */
    public static final String Sid = "aaf98f894f3a7ea3014f3b11858e00fa";

    /**
     * TOKEN
     */
    public static final String Token = "98178ab53fd04908851c6c7162f7d036";

    /**
     * AppId
     */
    public static final String AppId = "8a48b551506fd26f01507f8a2b4227cd";

    /**
     * CCPRestSmsSDK
     */
    private CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

    /**
     *
     */
    private void init() {
        restAPI.init(Address, Port);
        restAPI.setAccount(Sid, Token);
        restAPI.setAppId(AppId);
    }


    /**
     * Order: 【小黄蜂】过期通知，{1}，人数{2}，联系电话{3}
     */
    public static enum SMSType {

        Register("43437"), FindPass("43436"), Order("44075");

        private String tempCode;

        private SMSType(String tempCode) {
            this.tempCode = tempCode;
        }

        public String getTempCode() {
            return this.tempCode;
        }
    }

    /**
     *
     * @param type
     * @param phone
     * @param text
     * @return
     */
    public boolean sendSMS(SMSType type, String phone, String... text) {
        Map<String, Object> result = restAPI.sendTemplateSMS(phone, type.getTempCode() , text);
        if (!"000000".equals(result.get("statusCode"))) {
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return false;
        }
        return true;
    }


    /**
     * 发送短信
     */
    public String sendSMS(SMSType type, String phone) {
        String curTime = String.valueOf(System.currentTimeMillis());
        String code = String.valueOf(curTime).substring(curTime.length() - 4, curTime.length());
        Map<String, Object> result = restAPI.sendTemplateSMS(phone, type.getTempCode() ,new String[]{code});
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if (!"000000".equals(result.get("statusCode"))) {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
        return code;
    }


    public static SMSUtils getInstance() {
        return ourInstance;
    }

    private SMSUtils() {
        init();
    }
}
