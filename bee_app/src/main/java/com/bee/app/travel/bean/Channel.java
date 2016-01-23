package com.bee.app.travel.bean;

import com.bee.pojo.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 16/1/18.
 */
public class Channel implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8501565034721628019L;

    // 频道号
    private Long channelId;
    // 名字
    private String name;
    // 频道用户
    private List<User> users = new ArrayList<>();
    // 创建时间
    private Long createTime;

    public Long getChannelId() {
        return channelId;
    }
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
