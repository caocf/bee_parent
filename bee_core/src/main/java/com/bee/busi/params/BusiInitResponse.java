package com.bee.busi.params;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.pojo.shop.ShopTechee;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.spring.BaseResponse;

import java.util.List;

/**
 * Created by suntongwei on 15/10/10.
 */
public class BusiInitResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = -1541922321096097071L;

    /**
     * 商家所有群组
     */
    private List<BusiShopGroup> shopGroups;
    /**
     * 商家所有技师
     */
    private List<BusiShopTechee> shopTechees;
    /**
     * 商家出勤表
     */
    private List<BusiShopAttend> shopAttends;
    /**
     * 发送当前服务器时间
     */
    private Long currentTime;

    public List<BusiShopGroup> getShopGroups() {
        return shopGroups;
    }
    public void setShopGroups(List<BusiShopGroup> shopGroups) {
        this.shopGroups = shopGroups;
    }
    public List<BusiShopTechee> getShopTechees() {
        return shopTechees;
    }
    public void setShopTechees(List<BusiShopTechee> shopTechees) {
        this.shopTechees = shopTechees;
    }
    public List<BusiShopAttend> getShopAttends() {
        return shopAttends;
    }
    public void setShopAttends(List<BusiShopAttend> shopAttends) {
        this.shopAttends = shopAttends;
    }
    public Long getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
