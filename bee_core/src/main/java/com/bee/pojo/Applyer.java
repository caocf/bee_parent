package com.bee.pojo;

import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/27.
 */
@Entity
@Table(name = "TB_APPLYER")
public class Applyer implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6129392374901554337L;

    private Long aid;
    private String linkName;
    private String phone;
    private String extraInfo;
    private Long createTime;

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(createTime);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID", unique = true, nullable = false)
    public Long getAid() {
        return aid;
    }
    public void setAid(Long aid) {
        this.aid = aid;
    }
    @Column(name = "LINKNAME")
    public String getLinkName() {
        return linkName;
    }
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(name = "EXTRAINFO")
    public String getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
