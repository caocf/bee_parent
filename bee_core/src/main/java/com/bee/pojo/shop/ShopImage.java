package com.bee.pojo.shop;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/23.
 */
@Entity
@Table(name = "TB_SHOP_IMAGE")
public class ShopImage implements java.io.Serializable {

    // 主键
    private Long siid;
    // URL地址
    private String url;
    // 本地路径
    private String path;
    // 文字说明
    private String remark;
    // 类型
    private Integer type;
    // 排序
    private Integer sort;
    // 所属商家
    private Shop shop;

    public ShopImage() {}
    public ShopImage(Long id) {
        siid = id;
    }

    @Transient
    public ImageFactory.Image getImage() {
        return new ImageFactory.Image(getUrl());
    }

    @Transient
    public String getTypeStr() {
        String s = null;
        switch (getType()) {
            case Consts.Shop.ImageType.Big:
                s = "主图";
                break;
            case Consts.Shop.ImageType.Thumbnail:
                s = "缩略图";
                break;
            default:
                s = "";
        }
        return s;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIID", unique = true, nullable = false)
    public Long getSiid() {
        return siid;
    }
    public void setSiid(Long siid) {
        this.siid = siid;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
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
