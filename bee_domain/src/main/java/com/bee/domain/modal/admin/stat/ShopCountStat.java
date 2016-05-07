package com.bee.domain.modal.admin.stat;

/**
 * Created by suntongwei on 16/5/7.
 */
public class ShopCountStat implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1330794276039964694L;

    private String name;
    private Double count;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getCount() {
        return count;
    }
    public void setCount(Double count) {
        this.count = count;
    }
}
