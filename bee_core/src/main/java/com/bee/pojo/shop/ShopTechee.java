package com.bee.pojo.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/10/8.
 */
@Entity
@Table(name = "TB_SHOP_TECHEE")
public class ShopTechee implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2128126232675643557L;

    // 主键
    private Long stId;
    // 号码
    private String number;
    // 所属商家组
    private ShopGroup shopGroup;
    // 所属商家
    private Shop shop;

    public ShopTechee() {}
    public ShopTechee(Long id) {
        stId = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STID", unique = true, nullable = false)
    public Long getStId() {
        return stId;
    }
    public void setStId(Long stId) {
        this.stId = stId;
    }
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOPGROUP")
    public ShopGroup getShopGroup() {
        return shopGroup;
    }
    public void setShopGroup(ShopGroup shopGroup) {
        this.shopGroup = shopGroup;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
