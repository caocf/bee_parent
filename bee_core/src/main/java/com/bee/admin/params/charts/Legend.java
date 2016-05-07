package com.bee.admin.params.charts;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Chart Legend
 *
 * Created by suntongwei on 15/10/22.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Legend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7635374226508935836L;

    /**
     * 图例文字
     */
    private String[] data;


    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
}
