package com.bee.pojo.party;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/5/5.
 */
@Entity
@Table(name = "TB_PARTY_USER")
public class PartyUser implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -576679298272238983L;

    // 主键
    private Long puid;
    // 报名用户
    private User user;
    // 所属活动
    private Party party;
    // 报名时间
    private Long createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUID", unique = true, nullable = false)
    public Long getPuid() {
        return puid;
    }
    public void setPuid(Long puid) {
        this.puid = puid;
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
    @JoinColumn(name = "PARTY")
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
