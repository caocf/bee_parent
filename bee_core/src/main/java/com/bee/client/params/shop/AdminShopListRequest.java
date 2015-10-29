package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/16.
 */
public class AdminShopListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 1529406140351306476L;

    private String name;
    private Integer type;
    private String phone;
    private Long areaId;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
