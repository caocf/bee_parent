package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by suntongwei on 16/5/7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Grid implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6071385592589631285L;

    private String left;
    private String right;
    private String bottom;
    private Boolean containLabel;

    public String getLeft() {
        return left;
    }
    public void setLeft(String left) {
        this.left = left;
    }
    public String getRight() {
        return right;
    }
    public void setRight(String right) {
        this.right = right;
    }
    public String getBottom() {
        return bottom;
    }
    public void setBottom(String bottom) {
        this.bottom = bottom;
    }
    public Boolean getContainLabel() {
        return containLabel;
    }
    public void setContainLabel(Boolean containLabel) {
        this.containLabel = containLabel;
    }
}
