package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/5/5.
 */
public class PartyListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -166145041633258869L;

    private Long pid;
    private ImageFactory.Image image;
    private String explain;
    private Integer lookNum;
    private Double price;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public ImageFactory.Image getImage() {
        return image;
    }

    public void setImage(ImageFactory.Image image) {
        this.image = image;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
