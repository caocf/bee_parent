package com.bee.modal;

/**
 * Created by suntongwei on 15/6/30.
 */
public class ShopMap implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 5074788299643393786L;

    private Double lon;
    private Double lat;
    private Long shopId;
    private String name;
    private String addr;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
