package com.bee.easemob;

import com.easemob.server.comm.Constants;
import com.easemob.server.comm.HTTPMethod;
import com.easemob.server.comm.Roles;
import com.easemob.server.httpclient.utils.HTTPClientUtils;
import com.easemob.server.httpclient.vo.ClientSecretCredential;
import com.easemob.server.httpclient.vo.Credential;
import com.easemob.server.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by suntongwei on 16/1/3.
 */
public class EasemobFactory {

    /**
     * 注册IM用户[单个]
     * 给指定AppKey创建一个新的用户
     */
    public ObjectNode createUser(String identity) {
        Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username", identity);
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        // 返回结果
        return HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, datanode,
                HTTPMethod.METHOD_POST);
    }



    private static EasemobFactory ourInstance = new EasemobFactory();
    public static EasemobFactory getInstance() {
        return ourInstance;
    }
    private EasemobFactory() {
    }
}
