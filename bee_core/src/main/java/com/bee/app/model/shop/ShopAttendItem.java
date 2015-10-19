package com.bee.app.model.shop;

/**
 * Created by suntongwei on 15/10/18.
 */
public class ShopAttendItem implements java.io.Serializable {


    private static final long serialVersionUID = -1455292126295451815L;

    private String groupName;
    private String techeeNumber;


    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getTecheeNumber() {
        return techeeNumber;
    }
    public void setTecheeNumber(String techeeNumber) {
        this.techeeNumber = techeeNumber;
    }
}
