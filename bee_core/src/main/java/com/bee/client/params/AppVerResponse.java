package com.bee.client.params;

import com.qsd.framework.domain.response.Response;

/**
 * Created by suntongwei on 15/6/22.
 */
public class AppVerResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = 7003884002835051383L;

    private String remark;
    private String url;
    private String version;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}

