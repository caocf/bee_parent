package com.bee.admin.params.charts;

/**
 *
 * Created by suntongwei on 15/10/22.
 */
public class Chart implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1976900593526365500L;

    /**
     * 标题
     */
    private Title title;
    /**
     *
     */
    private Tooltip tooltip;
    /**
     * 图例
     */
    private Legend legend;
    /**
     * 工具栏
     */
    private ToolBox toolbox;
    /**
     * X轴
     */
    private Axis[] xAxis;
    /**
     * Y轴
     */
    private Axis[] yAxis;
    /**
     *
     */
    private Series[] series;


    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public Tooltip getTooltip() {
        return tooltip;
    }
    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }
    public Legend getLegend() {
        return legend;
    }
    public void setLegend(Legend legend) {
        this.legend = legend;
    }
    public ToolBox getToolbox() {
        return toolbox;
    }
    public void setToolbox(ToolBox toolbox) {
        this.toolbox = toolbox;
    }
    public Axis[] getxAxis() {
        return xAxis;
    }
    public void setxAxis(Axis[] xAxis) {
        this.xAxis = xAxis;
    }
    public Axis[] getyAxis() {
        return yAxis;
    }
    public void setyAxis(Axis[] yAxis) {
        this.yAxis = yAxis;
    }
    public Series[] getSeries() {
        return series;
    }
    public void setSeries(Series[] series) {
        this.series = series;
    }
}
