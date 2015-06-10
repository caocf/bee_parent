package com.bee.pojo.find;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/10.
 */
@Entity
@Table(name = "TB_FIND")
public class Find implements java.io.Serializable {

    // 主键
    private Long fid;
    // 所属用户
    private User user;
    // 创建时间
    private Long createTime;
    // 文字
    private String content;
    // 所属商家
    private Shop shop;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FID", unique = true, nullable = false)
    public Long getFid() {
        return fid;
    }
    public void setFid(Long fid) {
        this.fid = fid;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Lob
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
