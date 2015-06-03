package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/6/4.
 */
public class RecommendItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2189485495077802330L;

    private Long shopId;
    private ImageFactory.Image image;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
