package com.bee.pojo.store;

import javax.persistence.*;

/**
 * 商品类(积分商城奖品)
 *
 * Created by suntongwei on 15/10/21.
 */
@Entity
@Table(name = "TB_GOODS")
public class Goods implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7020933811909425719L;

    // 主键
    private Long gid;
    // 商品类型
    private Integer type;
    // 商品名称
    private String name;
    // 库存
    private Integer number;
    // 商品所需要积分
    private Integer integral;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GID", unique = true, nullable = false)
    public Long getGid() {
        return gid;
    }
    public void setGid(Long gid) {
        this.gid = gid;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "NUMBER")
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    @Column(name = "INTEGRAL")
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
