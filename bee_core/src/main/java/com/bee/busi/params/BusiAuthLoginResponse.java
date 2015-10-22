package com.bee.busi.params;

import com.bee.busi.model.user.BusiShopUser;
import com.bee.pojo.shop.ShopUser;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/10/5.
 */
public class BusiAuthLoginResponse extends BaseResponse implements java.io.Serializable {

    private static final long serialVersionUID = 8564441521809428186L;
    /**
     * 商家用户
     */
    private BusiShopUser shopUser;
    // 标识
    private Integer flag;
    // 是否是第一次登录，即判断密码是否是6个0的初始密码
    private Integer isFirstLogin;

    public BusiShopUser getShopUser() {
        return shopUser;
    }
    public void setShopUser(BusiShopUser shopUser) {
        this.shopUser = shopUser;
    }
    public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    public Integer getIsFirstLogin() {
        return isFirstLogin;
    }
    public void setIsFirstLogin(Integer isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }
}
