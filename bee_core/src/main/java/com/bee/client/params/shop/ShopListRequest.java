package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/30.
 */
public class ShopListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -7814828946282931137L;

    private Long uid;
    private String search;
    private Integer type;
    private Long areaId;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getAreaId() {
        return areaId;
    }
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
