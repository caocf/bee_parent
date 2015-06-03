package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/5/31.
 */
public class ShopImageListItem implements java.io.Serializable {

    private ImageFactory.Image image;
    private String remark;

    public ImageFactory.Image getImage() {
        return image;
    }

    public void setImage(ImageFactory.Image image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
