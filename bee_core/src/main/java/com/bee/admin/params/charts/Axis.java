package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Chart Axis
 *
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Axis implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2398272968965795752L;

    /**
     * 类型
     */
    private String type;
    /**
     * 两端留白策略
     */
    private Boolean boundaryGap;
    /**
     * 位置
     */
    private String position;
    /**
     * 数据
     */
    private String[] data;
    /**
     * AxisLabel
     */
    private AxisLabel axisLabel;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
    public Boolean getBoundaryGap() {
        return boundaryGap;
    }
    public void setBoundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
    }
    public AxisLabel getAxisLabel() {
        return axisLabel;
    }
    public void setAxisLabel(AxisLabel axisLabel) {
        this.axisLabel = axisLabel;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
