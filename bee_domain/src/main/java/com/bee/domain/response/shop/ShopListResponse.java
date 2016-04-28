package com.bee.domain.response.shop;

import com.bee.domain.modal.app.shop.ShopListItem;
import com.qsd.framework.domain.response.ResponsePaging;

import java.util.List;

/**
 * Created by suntongwei on 16/4/28.
 */
public class ShopListResponse extends ResponsePaging<ShopListItem> {

    // serialVersionUID
    private static final long serialVersionUID = -827160747430425563L;

    // 推广列表
    private List<ShopListItem> recommendList;

    public List<ShopListItem> getRecommendList() {
        return recommendList;
    }
    public void setRecommendList(List<ShopListItem> recommendList) {
        this.recommendList = recommendList;
    }
}
