package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 16/5/7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxisLabel implements java.io.Serializable {

    /**
     * 间隔
     */
    private Integer interval;

    public Integer getInterval() {
        return interval;
    }
    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
