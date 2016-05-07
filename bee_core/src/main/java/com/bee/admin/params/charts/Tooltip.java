package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tooltip implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3844646118208436931L;

    private String trigger;
    private AxisPointer axisPointer;

    public String getTrigger() {
        return trigger;
    }
    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    public AxisPointer getAxisPointer() {
        return axisPointer;
    }
    public void setAxisPointer(AxisPointer axisPointer) {
        this.axisPointer = axisPointer;
    }
}
