package com.bee.pojo;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_AREA")
public class Area implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2836268603259456188L;

    /**
     * 主键
     */
    private Long aid;
    /**
     * 地区名
     */
    private String name;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 排序
     */
    private Integer sort;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID", unique = true, nullable = false)
    public Long getAid() {
        return aid;
    }
    public void setAid(Long aid) {
        this.aid = aid;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "PARENTID")
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
