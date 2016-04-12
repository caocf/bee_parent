package com.bee.pojo;

import com.bee.pojo.find.Find;
import com.bee.pojo.shop.ShopUser;

import javax.persistence.*;

/**
 * 图片实体
 *
 * Created by suntongwei on 15/5/5.
 */
@Entity
@Table(name = "TB_IMAGE")
@Deprecated
public class Image implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7975413243729157317L;

    // 主键
    private Long iid;
    // 网络地址
    private String url;
    // 本地路径
    private String path;
    // 图片类型
    private Integer type;
    // 图片说明
    private String remark;
    // 原始宽
    private Integer width;
    // 原始高
    private Integer height;
    // 创建时间
    private Long createTime;
    // 图片排序
    private Integer sort;

    // 是否是商家管理员图片
    private ShopUser shopUser = new ShopUser(0l);
    // 发现图片集合
    private Find find = new Find(0l);

    public Image() {}
    public Image(Long id) {
        iid = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IID", unique = true, nullable = false)
    public Long getIid() {
        return iid;
    }
    public void setIid(Long iid) {
        this.iid = iid;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_USER")
    public ShopUser getShopUser() {
        return shopUser;
    }
    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "FIND")
    public Find getFind() {
        return find;
    }
    public void setFind(Find find) {
        this.find = find;
    }
    @Column(name = "WIDTH")
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    @Column(name = "HEIGHT")
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
}
