package com.bee.pojo.user;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/30.
 */
@Entity
@Table(name = "TB_USER_FRIEND")
public class UserFriend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1434986024276486984L;

    private Long ufId;
    private User user;
    private User friend;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UFID", unique = true, nullable = false)
    public Long getUfId() {
        return ufId;
    }
    public void setUfId(Long ufId) {
        this.ufId = ufId;
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
    @JoinColumn(name = "FRIEND")
    public User getFriend() {
        return friend;
    }
    public void setFriend(User friend) {
        this.friend = friend;
    }
}
