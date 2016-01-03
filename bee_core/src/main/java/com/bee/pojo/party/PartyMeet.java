package com.bee.pojo.party;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/5/5.
 */
@Entity
@Table(name = "TB_PARTY_MEET")
public class PartyMeet implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2063540222987309832L;

    private Long pmid;
    private Double price;
    private String remark;
    private String addr;
    private Long lon;
    private Long lat;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PMID", unique = true, nullable = false)
    public Long getPmid() {
        return pmid;
    }
    public void setPmid(Long pmid) {
        this.pmid = pmid;
    }
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "ADDR")
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    @Column(name = "LON")
    public Long getLon() {
        return lon;
    }
    public void setLon(Long lon) {
        this.lon = lon;
    }
    @Column(name = "LAT")
    public Long getLat() {
        return lat;
    }
    public void setLat(Long lat) {
        this.lat = lat;
    }
}
