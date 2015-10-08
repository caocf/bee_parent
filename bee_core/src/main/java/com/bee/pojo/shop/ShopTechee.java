package com.bee.pojo.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/10/8.
 */
@Entity
@Table(name = "TB_SHOP_TECHEE")
@JsonIgnoreProperties({"shopGroup"})
public class ShopTechee implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2128126232675643557L;

    // 主键
    private Long stId;
    // 号码
    private String number;
    // 所属商家组
    private ShopGroup shopGroup;

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
}
