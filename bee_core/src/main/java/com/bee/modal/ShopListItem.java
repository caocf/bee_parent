package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/4/30.
 */
public class ShopListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1131654802813555382L;

    private Long shopId;
    private String image;
    private String area;
    private String name;
    private String addr;
    private Integer friendNum;
    private Integer focusNum;
    private Double price;

    public String getImage() {
        return new ImageFactory.Image(image).getMainPic();
    }

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public void setImage(String image) {
        this.image = image;
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
    public Integer getFriendNum() {
        return friendNum;
    }
    public void setFriendNum(Integer friendNum) {
        this.friendNum = friendNum;
    }
    public Integer getFocusNum() {
        return focusNum;
    }
    public void setFocusNum(Integer focusNum) {
        this.focusNum = focusNum;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
}
