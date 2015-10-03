package com.bee.pojo.shop;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_SHOP_PRICE")
public class ShopPrice implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -4528081940882620390L;

    private Long spid;
    private Double price;
    private String title;
    private String discount;
    private String mark;
    private Integer sort;
    private Shop shop;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPID", unique = true, nullable = false)
    public Long getSpid() {
        return spid;
    }
    public void setSpid(Long spid) {
        this.spid = spid;
    }
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "MARK")
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "DISCOUNT")
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
