package com.bee.admin.commons;

/**
 * Created by suntongwei on 15/11/7.
 */
public class AdminConsts {

    public static final boolean isDebug = false;

    private static final String LocalBaseUrl = "http://localhost:8080";
    private static final String RemoteBaseUrl = "http://139.196.27.231/admin";

    public static String getBaseUrl() {
        return isDebug ? LocalBaseUrl : RemoteBaseUrl;
    }

    public static String GetRemoteImageUrl() {
        return RemoteBaseUrl;
    }

}
