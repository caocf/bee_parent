package com.bee.app.model.store;

/**
 * Created by suntongwei on 15/10/21.
 */
public class GoodsListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2547746810792992870L;

    private Long gid;
    private String name;
    private Integer integral;
    private Integer number;

    public Long getGid() {
        return gid;
    }
    public void setGid(Long gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
