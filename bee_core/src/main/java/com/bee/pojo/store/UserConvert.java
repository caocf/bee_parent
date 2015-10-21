package com.bee.pojo.store;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * 用户兑换记录
 *
 * Created by suntongwei on 15/10/21.
 */
@Entity
@Table(name = "TB_USER_CONVERT")
public class UserConvert implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -5735487736215499052L;

    // 主键
    private Long ucId;
    // 兑换商品
    private Goods goods;
    // 兑换用户
    private User user;
    // 卡密
    private String cardNumber;
    // 兑换时间
    private Long createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UCID", unique = true, nullable = false)
    public Long getUcId() {
        return ucId;
    }
    public void setUcId(Long ucId) {
        this.ucId = ucId;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS")
    public Goods getGoods() {
        return goods;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "CARDNUMBER")
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
