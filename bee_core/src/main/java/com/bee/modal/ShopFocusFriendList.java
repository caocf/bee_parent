package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/5/4.
 */
public class ShopFocusFriendList implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6462440660001882295L;

    private Long uid;
    private String name;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
