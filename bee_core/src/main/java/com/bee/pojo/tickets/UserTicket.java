package com.bee.pojo.tickets;

import com.bee.commons.Consts;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;

import javax.persistence.*;


/**
 * Created by suntongwei on 16/1/2.
 */
@Entity
@Table(name = "TB_USER_TICKET")
public class UserTicket implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3828082796088245549L;

    // 主键
    private Long utId;
    // 优惠券
    private Ticket ticket;
    // 所属订单
    private Order order;
    // 使用状态
    private Integer status;
    // 所属用户
    private User user;
    // 创建时间
    private Long createTime;
    // 有效期,如果无有效期,则endTime为0
    private Long startTime;
    private Long stopTime;

    public UserTicket() {}
    public UserTicket(Long id) {
        this.utId = id;
    }

    /**
     * 判断是否可用红包
     *
     * @return
     */
    @Transient
    public boolean isUseTicket() {
        return status == Consts.Ticket.Status.Normal
                && (stopTime > System.currentTimeMillis() || stopTime == 0);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UTID", unique = true, nullable = false)
    public Long getUtId() {
        return utId;
    }
    public void setUtId(Long utId) {
        this.utId = utId;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET")
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
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
    @Column(name = "STARTTIME")
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    @Column(name = "STOPTIME")
    public Long getStopTime() {
        return stopTime;
    }
    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "T_ORDER")
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
