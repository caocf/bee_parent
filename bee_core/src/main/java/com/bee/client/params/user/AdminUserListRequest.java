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
    private String userName;
    private String phone;
    private Integer integral;
    private Integer maxRows;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
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
            case Consts.User.Type.TestUser:
                pageType = "navbar-inner-user-test";
                break;
            default:
                pageType = "navbar-inner-user-app";
        }
        return pageType;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    @Override
    public Integer getMaxRows() {
        if (maxRows != null) {
            return maxRows;
        }
        return 15;
    }
}
