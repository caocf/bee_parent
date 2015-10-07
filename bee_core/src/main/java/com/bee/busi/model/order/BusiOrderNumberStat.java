package com.bee.busi.model.order;

/**
 * Created by suntongwei on 15/10/7.
 */
public class BusiOrderNumberStat implements java.io.Serializable {

    private static final long serialVersionUID = 9090238372407180926L;

    // 今天成功订单数
    private Long today;
    // 今日总订单数
    private Long todayTotal;
    // 一周订单数
    private Long total;

    public Long getToday() {
        return today;
    }
    public void setToday(Long today) {
        this.today = today;
    }
    public Long getTodayTotal() {
        return todayTotal;
    }
    public void setTodayTotal(Long todayTotal) {
        this.todayTotal = todayTotal;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
}
