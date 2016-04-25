package com.bee.pojo.find;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/13.
 */
@Entity
@Table(name = "TB_FIND_REPLY")
public class FindReply implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1630227591650706921L;

    private Long frid;
    private String content;
    private Long createTime;
    private Find find;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FRID", unique = true, nullable = false)
    public Long getFrid() {
        return frid;
    }
    public void setFrid(Long frid) {
        this.frid = frid;
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
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "FIND")
    public Find getFind() {
        return find;
    }
    public void setFind(Find find) {
        this.find = find;
    }
}
