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
        String pageType = null;
        switch (getType()) {
            case Consts.User.Type.VipUser:
                pageType = "UserVip";
                break;
            case Consts.User.Type.PinkUser:
                pageType = "UserPink";
                break;
            case Consts.User.Type.BussUser:
                pageType = "UserBuss";
                break;
            case Consts.User.Type.AdminUser:
                pageType = "UserAdmin";
                break;
            default:
                pageType = "UserApp";
        }
        return pageType;
    }

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
