package com.bee.pojo.tickets;

import com.bee.pojo.shop.Shop;

import javax.persistence.*;

/**
 * 优惠券
 *
 * Created by suntongwei on 15/12/25.
 */
@Entity
@Table(name = "TB_TICKET")
public class Ticket implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6281770699183902191L;

    // 主键
    private Long tid;
    // 类型
    private Integer type;
    // 抵扣金额,如类型是全免等,则为0
    private Double price;
    // 所限制店
    private Shop shop;
    // 说明
    private String remark;
    // 标题
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TID", unique = true, nullable = false)
    public Long getTid() {
        return tid;
    }
    public void setTid(Long tid) {
        this.tid = tid;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
