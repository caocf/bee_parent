package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/5/5.
 */
public class AdListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -5543371046285196506L;

    private Long adid;
    private Integer type;
    private ImageFactory.Image image;
    private Long shopId;
    private Long stopTime;
    private Long startTime;
    private Integer sort;

    public Long getAdid() {
        return adid;
    }
    public void setAdid(Long adid) {
        this.adid = adid;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public ImageFactory.Image getImage() {
        return image;
    }
    public void setImage(ImageFactory.Image image) {
        this.image = image;
    }
    public Long getStopTime() {
        return stopTime;
    }
    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
