package com.bee.pojo.shop;

import javax.persistence.*;

/**
 * 商家技师出勤表
 *
 * v1.1.0 删除该表
 * 不单独保存出勤数据, 出勤标识直接使用ShopTechee表的attend字段
 *
 * Created by suntongwei on 15/10/8.
 */
@Entity
@Table(name = "TB_SHOP_ATTEND")
@Deprecated
public class ShopAttend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -4340767143298782674L;

    // 主键
    private Long saId;
    // 技师
    private ShopTechee shopTechee;
    // 出勤时间
    private Long attendTime;
    // 所属商家
    private Shop shop;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAID", unique = true, nullable = false)
    public Long getSaId() {
        return saId;
    }
    public void setSaId(Long saId) {
        this.saId = saId;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOPTECHEE")
    public ShopTechee getShopTechee() {
        return shopTechee;
    }
    public void setShopTechee(ShopTechee shopTechee) {
        this.shopTechee = shopTechee;
    }
    @Column(name = "ATTENDTIME")
    public Long getAttendTime() {
        return attendTime;
    }
    public void setAttendTime(Long attendTime) {
        this.attendTime = attendTime;
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
