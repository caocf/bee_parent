package com.bee.admin.params.charts;

/**
 * Created by suntongwei on 15/10/22.
 */
public class Series implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3544245841220136344L;

    private String name;
    private String type;
    private Double[] data;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double[] getData() {
        return data;
    }
    public void setData(Double[] data) {
        this.data = data;
    }
}
