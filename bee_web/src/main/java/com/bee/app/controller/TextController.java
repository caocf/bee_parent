package com.bee.app.controller;

import com.bee.commons.Consts;
import com.easemob.server.comm.Constants;
import com.easemob.server.comm.HTTPMethod;
import com.easemob.server.comm.Roles;
import com.easemob.server.httpclient.utils.HTTPClientUtils;
import com.easemob.server.httpclient.vo.ClientSecretCredential;
import com.easemob.server.httpclient.vo.Credential;
import com.easemob.server.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/6.
 */
@RestController
public class TextController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);

        // 目标用户
        ArrayNode target = JsonNodeFactory.instance.arrayNode();
        target.add("1052");

        // 消息体
        ObjectNode txtmsg = JsonNodeFactory.instance.objectNode();
        txtmsg.put("msg", "您有一条新订单");
        txtmsg.put("type","txt");

        // 消息扩展字段
        ObjectNode ext = JsonNodeFactory.instance.objectNode();
        ext.put("orderId", 1);

        ObjectNode dataNode = JsonNodeFactory.instance.objectNode();
        dataNode.put("target_type", "users");
        dataNode.put("target", target);
        dataNode.put("msg", txtmsg);
        dataNode.put("from", Consts.HXConfig.SystemAdminHXName);
        dataNode.put("ext", ext);

        ObjectNode res = HTTPClientUtils.sendHTTPRequest(EndPoints.MESSAGES_URL, credential, dataNode,
                HTTPMethod.METHOD_POST);

        if (res != null) {
            return res.toString();
        }
        return "";
    }


}
