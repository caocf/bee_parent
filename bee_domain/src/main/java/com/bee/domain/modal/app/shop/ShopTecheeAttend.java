package com.bee.domain.modal.app.shop;

/**
 * <b>商家技师出勤表实体</b>
 * 该类主要用户显示出勤表列表,用于给用户点选出勤技师
 *
 * Created by suntongwei on 16/4/11.
 */
public class ShopTecheeAttend implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 5143848128331071989L;

    // 技师ID
    private Long stId;
    // 技师编号
    private String number;
    // 是否出勤
    private Integer attend;

    // 组ID
    private Long groupId;
    // 所属组名
    private String groupName;

    public Long getStId() {
        return stId;
    }
    public void setStId(Long stId) {
        this.stId = stId;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Integer getAttend() {
        return attend;
    }
    public void setAttend(Integer attend) {
        this.attend = attend;
    }
    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
