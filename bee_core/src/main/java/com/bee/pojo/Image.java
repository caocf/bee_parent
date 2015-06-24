package com.bee.pojo;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/5/5.
 */
@Entity
@Table(name = "TB_IMAGE")
public class Image implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7975413243729157317L;

    // 主键
    private Long iid;
    // 网络地址
    private String url;
    // 本地路径
    private String path;
    // 图片类型
    private Integer type;
    // 图片说明
    private String remark;
    // 创建时间
    private Long createTime;
    // 图片排序
    private Integer sort;

    public Image() {}
    public Image(Long id) {
        iid = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IID", unique = true, nullable = false)
    public Long getIid() {
        return iid;
    }
    public void setIid(Long iid) {
        this.iid = iid;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
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
}
