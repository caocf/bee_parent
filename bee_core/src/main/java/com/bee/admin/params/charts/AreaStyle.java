package com.bee.admin.params.charts;

/**
 * Created by suntongwei on 15/11/11.
 */
public class AreaStyle implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -7964572124552254444L;

    // 目前只有default
    private String type = "default";

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
