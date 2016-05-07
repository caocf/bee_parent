package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 15/11/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemStyle implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 9113417921092551339L;

    private Normal normal;

    public Normal getNormal() {
        return normal;
    }
    public void setNormal(Normal normal) {
        this.normal = normal;
    }
}
