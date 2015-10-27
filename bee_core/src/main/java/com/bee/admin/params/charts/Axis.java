package com.bee.admin.params.charts;

/**
 * Chart Axis
 *
 * Created by suntongwei on 15/10/22.
 */
public class Axis implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2398272968965795752L;

    /**
     * 类型
     */
    private String type;
    /**
     * 数据
     */
    private String[] data;


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
}
