package com.bee.pojo.find;

import com.bee.pojo.shop.ShopImage;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/11/29.
 */
@Entity
@Table(name = "TB_FIND_IMAGE")
public class FindImage implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2666112469601307868L;

    // 主键
    private Long fiId;
    // 图片类型
    private Integer type;
    // 商家相册图片
    private ShopImage shopImage;
    // 图片URL
    private String url;
    // 所属发现
    private Find find;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIID", unique = true, nullable = false)
    public Long getFiId() {
        return fiId;
    }
    public void setFiId(Long fiId) {
        this.fiId = fiId;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "FIND")
    public Find getFind() {
        return find;
    }
    public void setFind(Find find) {
        this.find = find;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOPIMAGE")
    public ShopImage getShopImage() {
        return shopImage;
    }
    public void setShopImage(ShopImage shopImage) {
        this.shopImage = shopImage;
    }
}
