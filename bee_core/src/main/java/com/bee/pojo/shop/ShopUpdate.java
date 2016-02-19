package com.bee.pojo.shop;

import javax.persistence.*;

/**
 * Created by suntongwei on 16/2/17.
 */
@Entity
@Table(name = "TB_SHOP_UPDATE")
public class ShopUpdate implements java.io.Serializable {

    // 主键
    private Long suId;
    // 所属商家
    private Shop shop;
    // 更新技师时间
    private Long updateTechee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUID", unique = true, nullable = false)
    public Long getSuId() {
        return suId;
    }
    public void setSuId(Long suId) {
        this.suId = suId;
    }
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "UPDATETECHEE")
    public Long getUpdateTechee() {
        return updateTechee;
    }
    public void setUpdateTechee(Long updateTechee) {
        this.updateTechee = updateTechee;
    }
}
