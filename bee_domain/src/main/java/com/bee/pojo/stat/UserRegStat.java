package com.bee.pojo.stat;

import javax.persistence.*;

/**
 * 2015-10-23
 * 删除该类
 *
 * Created by suntongwei on 15/5/7.
 */
@Deprecated
@Entity
@Table(name = "TB_USER_REG_STAT")
public class UserRegStat implements java.io.Serializable {

    private Long ursid;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer num;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "URSID", unique = true, nullable = false)
    public Long getUrsid() {
        return ursid;
    }
    public void setUrsid(Long ursid) {
        this.ursid = ursid;
    }
    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    @Column(name = "MONTH")
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    @Column(name = "DAY")
    public Integer getDay() {
        return day;
    }
    public void setDay(Integer day) {
        this.day = day;
    }
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
}
