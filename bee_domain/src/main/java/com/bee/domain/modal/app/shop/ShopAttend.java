package com.bee.domain.modal.app.shop;

/**
 * Created by suntongwei on 15/11/22.
 */
public class ShopAttend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -9051862787605907871L;

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
