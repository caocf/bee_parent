package com.bee.admin.params.charts;

/**
 * Created by suntongwei on 15/10/22.
 */
public class Tooltip implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3844646118208436931L;

    private String trigger;

    public String getTrigger() {
        return trigger;
    }
    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
}
