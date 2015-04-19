package com.bee.pojo.shop;

import com.bee.pojo.user.User;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/19.
 */
@Entity
@Table(name = "TB_SHOP_FOCUS")
public class ShopFocus implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1798982872772893139L;

    private Long sfid;
    private Shop shop;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SFID", unique = true, nullable = false)
    public Long getSfid() {
        return sfid;
    }
    public void setSfid(Long sfid) {
        this.sfid = sfid;
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
}
