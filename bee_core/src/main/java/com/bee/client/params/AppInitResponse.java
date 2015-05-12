package com.bee.client.params;

import com.bee.modal.AdListItem;
import com.qsd.framework.spring.BaseResponse;

import java.util.List;

/**
 * Created by suntongwei on 15/5/11.
 */
public class AppInitResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -7078274754894585475L;

    /**
     * 服务器返回更新时间，防止手机时间错误
     */
    private Long updateTime;
    /**
     * 新的广告
     */
    private List<AdListItem> newAds;


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
}
