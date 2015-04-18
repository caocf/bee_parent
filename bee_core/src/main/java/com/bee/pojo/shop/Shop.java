package com.bee.pojo.shop;

import com.bee.pojo.Area;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_SHOP")
public class Shop implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -3492061204002404978L;

    // 主键
    private Long sid;
    // 商家标识
    private String identity;
    // 名字
    private String name;
    // 所属地区
    private Area area;
    // 类型
    private Integer type;
    // 状态
    private Integer status;
    // 联系人
    private String linkName;
    // 商家联系电话
    private String phone;
    // 地址
    private String addr;
    // 创建时间
    private Long createTime;
    // 权重
    private Integer sort;
    // 权重到期日
    private Long sortTime;
    // 介绍
    private String remark;
    // 推荐
    private Integer recommend;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SID", unique = true, nullable = false)
    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    @Column(name = "IDENTITY")
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "AREA")
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
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
    @Column(name = "ADDR")
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name = "SORTTIME")
    public Long getSortTime() {
        return sortTime;
    }
    public void setSortTime(Long sortTime) {
        this.sortTime = sortTime;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "RECOMMEND")
    public Integer getRecommend() {
        return recommend;
    }
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
