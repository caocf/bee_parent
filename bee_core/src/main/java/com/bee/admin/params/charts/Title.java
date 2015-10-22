package com.bee.admin.params.charts;

/**
 * Chart Title
 *
 * Created by suntongwei on 15/10/22.
 */
public class Title implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2740262670175597255L;

    /**
     * 标题
     */
    private String text;
    /**
     * 副标题
     */
    private String subtext = "";

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getSubtext() {
        return subtext;
    }
    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }
}
