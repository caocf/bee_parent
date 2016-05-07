package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 16/5/7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxisPointer implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8791532895654179933L;

    private String type;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
