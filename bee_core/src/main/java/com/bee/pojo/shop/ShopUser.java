package com.bee.pojo.shop;

import com.bee.pojo.Image;
import com.bee.pojo.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 15/7/9.
 */
@Entity
@Table(name = "TB_SHOP_USER")
public class ShopUser implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2848880071317878174L;

    private Long suid;
    private Shop shop;
    private User user;
    private String introduce;
    private List<Image> images = new ArrayList<>(0);

    public ShopUser(){}
    public ShopUser(long id) {
        suid = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUID", unique = true, nullable = false)
    public Long getSuid() {
        return suid;
    }
    public void setSuid(Long suid) {
        this.suid = suid;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Lob
    @Column(name = "INTRODUCE")
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "shopUser")
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }
}