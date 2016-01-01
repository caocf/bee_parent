package com.bee.pojo;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/12/25.
 */
@Entity
@Table(name = "TB_SYSTEM_CONFIG")
public class SystemConfig implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -4718282164116687086L;

    private Long scId;
    private Integer type;
    private Long flag;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCID", unique = true, nullable = false)
    public Long getScId() {
        return scId;
    }
    public void setScId(Long scId) {
        this.scId = scId;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "FLAG")
    public Long getFlag() {
        return flag;
    }
    public void setFlag(Long flag) {
        this.flag = flag;
    }
}
