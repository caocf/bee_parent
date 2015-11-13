package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 15/11/11.
 */
public class Normal implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -386314827923782861L;

    private AreaStyle areaStyle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public AreaStyle getAreaStyle() {
        return areaStyle;
    }
    public void setAreaStyle(AreaStyle areaStyle) {
        this.areaStyle = areaStyle;
    }
}
