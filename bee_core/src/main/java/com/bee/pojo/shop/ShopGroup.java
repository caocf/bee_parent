package com.bee.pojo.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/10/8.
 */
@Entity
@Table(name = "TB_SHOP_GROUP")
@JsonIgnoreProperties({"shop"})
public class ShopGroup implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -3243135882371937198L;

    // 主键
    private Long sgId;
    // 组名
    private String groupName;
    // 所属商家
    private Shop shop;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SGID", unique = true, nullable = false)
    public Long getSgId() {
        return sgId;
    }
    public void setSgId(Long sgId) {
        this.sgId = sgId;
    }
    @Column(name = "GROUPNAME")
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
