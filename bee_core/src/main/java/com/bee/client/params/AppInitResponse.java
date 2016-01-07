package com.bee.client.params;

import com.bee.domain.modal.app.user.MessageList;
import com.bee.modal.AdListItem;
import com.bee.pojo.Area;
import com.qsd.framework.spring.BaseResponse;

import java.util.List;

/**
 * Created by suntongwei on 15/5/11.
 */
public class AppInitResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -7078274754894585475L;

    /**
     * 服务器状态
     */
    private Integer serverStatus;

    /**
     * 服务器返回更新时间，防止手机时间错误
     */
    private Long updateTime;
    /**
     * 新的广告
     */
    private List<AdListItem> newAds;
    /**
     * 最新APP版本
     */
    private Integer newVersion;

    /**
     * 客服电话
     */
    private String servicePhone;

    /**
     * 地区列表
     */
    private List<Area> areaList;

    /**
     * 用户新消息
     */
    private Integer newMessageNum;

    /**
     * 首页和发现图片更新时间
     */
    private Long mainAdUpdateTime;
    private Long findAdUpdateTime;
    /**
     * 分享二维码图片更新时间
     */
    private Long qrImageUpdateTime;

    public Integer getNewVersion() {
        return newVersion;
    }
    public void setNewVersion(Integer newVersion) {
        this.newVersion = newVersion;
    }
    public List<AdListItem> getNewAds() {
        return newAds;
    }
    public void setNewAds(List<AdListItem> newAds) {
        this.newAds = newAds;
    }
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    public String getServicePhone() {
        return servicePhone;
    }
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
    public Integer getServerStatus() {
        return serverStatus;
    }
    public void setServerStatus(Integer serverStatus) {
        this.serverStatus = serverStatus;
    }
    public List<Area> getAreaList() {
        return areaList;
    }
    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
    public Long getMainAdUpdateTime() {
        return mainAdUpdateTime;
    }
    public void setMainAdUpdateTime(Long mainAdUpdateTime) {
        this.mainAdUpdateTime = mainAdUpdateTime;
    }
    public Long getFindAdUpdateTime() {
        return findAdUpdateTime;
    }
    public void setFindAdUpdateTime(Long findAdUpdateTime) {
        this.findAdUpdateTime = findAdUpdateTime;
    }
    public Long getQrImageUpdateTime() {
        return qrImageUpdateTime;
    }
    public void setQrImageUpdateTime(Long qrImageUpdateTime) {
        this.qrImageUpdateTime = qrImageUpdateTime;
    }
    public Integer getNewMessageNum() {
        return newMessageNum;
    }
    public void setNewMessageNum(Integer newMessageNum) {
        this.newMessageNum = newMessageNum;
    }
}
