package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 15/11/11.
 */
public class ItemStyle implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 9113417921092551339L;

    private Normal normal;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Normal getNormal() {
        return normal;
    }
    public void setNormal(Normal normal) {
        this.normal = normal;
    }
}
