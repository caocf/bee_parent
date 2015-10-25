package com.bee.client.params.user;

import com.bee.commons.Consts;
import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/27.
 */
public class AdminUserListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -3173318421242792847L;

    private Integer type;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public String getPageType() {
        String pageType;
        switch (getType()) {
            case Consts.User.Type.VipUser:
                pageType = "navbar-inner-user-vip";
                break;
            case Consts.User.Type.PinkUser:
                pageType = "navbar-inner-user-pink";
                break;
            case Consts.User.Type.BusiUser:
                pageType = "navbar-inner-user-buss";
                break;
            case Consts.User.Type.AdminUser:
                pageType = "navbar-inner-user-admin";
                break;
            default:
                pageType = "navbar-inner-user-app";
        }
        return pageType;
    }

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
