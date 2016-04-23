package com.bee.pojo.shop;

import javax.persistence.*;

/**
 * Created by suntongwei on 16/4/23.
 */
@Entity
@Table(name = "TB_SHOP_CONFIG")
public class ShopConfig implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1809770439243794088L;

    // 主键
    private Long scId;
    // 所属商家
    private Shop shop;
    // 是否有宣传视频
    private Integer hasVideo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCID", unique = true, nullable = false)
    public Long getScId() {
        return scId;
    }
    public void setScId(Long scId) {
        this.scId = scId;
    }
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "HASVIDEO")
    public Integer getHasVideo() {
        return hasVideo;
    }
    public void setHasVideo(Integer hasVideo) {
        this.hasVideo = hasVideo;
    }
}
