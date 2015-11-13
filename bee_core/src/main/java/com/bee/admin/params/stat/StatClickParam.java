package com.bee.admin.params.stat;

/**
 * Created by suntongwei on 15/11/11.
 */
public class StatClickParam implements java.io.Serializable {

    // X轴名称
    private String name;

    //
    private Integer seriesIndex;
    private Integer dataIndex;

    // 值
    private String value;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSeriesIndex() {
        return seriesIndex;
    }
    public void setSeriesIndex(Integer seriesIndex) {
        this.seriesIndex = seriesIndex;
    }
    public Integer getDataIndex() {
        return dataIndex;
    }
    public void setDataIndex(Integer dataIndex) {
        this.dataIndex = dataIndex;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
