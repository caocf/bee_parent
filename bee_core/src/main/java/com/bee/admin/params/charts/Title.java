package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Chart Title
 *
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    /**
     * 是否显示
     */
    private Boolean show = true;

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
    public Boolean getShow() {
        return show;
    }
    public void setShow(Boolean show) {
        this.show = show;
    }
}
