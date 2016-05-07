package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chart implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1976900593526365500L;

    /**
     * 标题
     */
    private Title title;
    /**
     * Tooltip
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
     * Series
     */
    private Series[] series;
    /**
     * Grid
     */
    private Grid grid;
    /**
     * 默认取色方案
     * 官方默认值:
     * "#c23531", "#2f4554", "#61a0a8", "#d48265", "#91c7ae", "#749f83",
     * "#ca8622", "#bda29a", "#6e7074", "#546570", "#c4ccd3"
     */
    private String[] color = new String[] {
            "#2f4554", "#c23531", "#61a0a8", "#d48265", "#91c7ae", "#749f83",
            "#ca8622", "#bda29a", "#6e7074", "#546570", "#c4ccd3"
    };

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
    public Grid getGrid() {
        return grid;
    }
    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    public String[] getColor() {
        return color;
    }
    public void setColor(String[] color) {
        this.color = color;
    }
}
