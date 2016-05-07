package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolBox implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7017196292838226484L;

    /**
     * 是否显示
     */
    private Boolean show;

    private Feature feature;

    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
    public Feature getFeature() {
        return feature;
    }
    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
