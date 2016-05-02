package com.bee.pojo.shop;

import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/1.
 */
@Entity
@Table(name = "TB_SHOP_COMMENT")
public class ShopComment implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -7176615784874395259L;

    // 主键
    private Long scid;
    // 评论内容
    private String content;
    // 所属用户
    private User user;
    // 所属商家
    private Shop shop;
    // 创建时间
    private Long createTime;
    // 所属订单
    private Order order;
    // 回复数
    private Integer replyNum;

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(createTime);
    }

    public ShopComment(){}
    public ShopComment(Long scid) {
        this.scid = scid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCID", unique = true, nullable = false)
    public Long getScid() {
        return scid;
    }
    public void setScid(Long scid) {
        this.scid = scid;
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
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "`ORDER`")
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    @Column(name = "REPLYNUM")
    public Integer getReplyNum() {
        return replyNum;
    }
    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }
}
