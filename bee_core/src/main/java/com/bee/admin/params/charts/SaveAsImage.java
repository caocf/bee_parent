package com.bee.admin.params.charts;

/**
 * Created by suntongwei on 15/10/22.
 */
public class SaveAsImage implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7566905754543637021L;

    /**
     * 是否显示
     */
    private Boolean show;

    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
}
