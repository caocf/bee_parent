package com.bee.pojo.shop;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/11.
 */
@Entity
@Table(name = "TB_SHOP_REPLY")
public class ShopReply implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -534369103840378382L;

    private Long srid;
    private String content;
    private Long createTime;
    private ShopComment ShopComment;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SRID", unique = true, nullable = false)
    public Long getSrid() {
        return srid;
    }
    public void setSrid(Long srid) {
        this.srid = srid;
    }
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOPCOMMENT")
    public ShopComment getShopComment() {
        return ShopComment;
    }
    public void setShopComment(ShopComment shopComment) {
        ShopComment = shopComment;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
