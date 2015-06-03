package com.bee.modal;

/**
 * Created by suntongwei on 15/6/2.
 */
public class OrderListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -879359212825537989L;

    private Long oid;
    private String name;
    private Long time;
    private Integer num;
    private Integer status;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
