package com.bee.pojo.user;

import com.qsd.framework.security.entity.ISecurityAuth;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/11/2.
 */
@Entity
@Table(name = "TB_USER_AUTH")
public class UserAuth implements java.io.Serializable, ISecurityAuth {

    // 主键
    private Long uaId;
    // 权限名
    private String authName;
    // 所属用户
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UAID", unique = true, nullable = false)
    public Long getUaId() {
        return uaId;
    }
    public void setUaId(Long uaId) {
        this.uaId = uaId;
    }
    @Override
    @Column(name = "AUTHNAME")
    public String getAuthName() {
        return authName;
    }
    public void setAuthName(String authName) {
        this.authName = authName;
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
