package com.bee.busi.model.order;

/**
 * Created by suntongwei on 15/10/7.
 */
public class BusiOrderNumberStat implements java.io.Serializable {

    private static final long serialVersionUID = 9090238372407180926L;

    // 今天成功订单数
    private Integer today;
    // 今日总订单数
    private Integer todayTotal;
    // 一周订单数
    private Integer total;

    public Integer getToday() {
        return today;
    }
    public void setToday(Integer today) {
        this.today = today;
    }
    public Integer getTodayTotal() {
        return todayTotal;
    }
    public void setTodayTotal(Integer todayTotal) {
        this.todayTotal = todayTotal;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
}
