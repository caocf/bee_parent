package com.bee.pojo.party;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/5/5.
 */
@Entity
@Table(name = "TB_PARTY")
public class Party implements java.io.Serializable {

    // 主键
    private Long pid;
    private Integer type;
    private Long childId;
    private String path;
    private String url;
    private String title;
    private Integer lookNum;
    private String partyTime;
    private Long startTime;
    private Long stopTime;
    private Integer sort;
    private Integer isBee;
    private Long createTime;

    @Transient
    public ImageFactory.Image getImage() {
        return new ImageFactory.Image(getUrl(), ImageFactory.ImageType.PartyMainSize);
    }

    @Transient
    public String getTypeStr() {
        String typeStr = "";
        if(type == Consts.Party.Type.Offline) {
            typeStr = "线下活动";
        }
        return typeStr;
    }

    @Transient
    public String getStatus() {
        String status = "";
        if(System.currentTimeMillis() > stopTime) {
            status = "已结束";
        } else if(System.currentTimeMillis() < startTime) {
            status = "等待上架";
        } else {
            status = "进行中";
        }
        return status;
    }

    @Transient
    public String getStartTimeStr() {
        return DateUtil.formatDate(startTime);
    }
    public void setStartTimeStr(String startTime) {
        this.startTime = DateUtil.parseDateLong(startTime + " 00:00:00");
    }
    @Transient
    public String getStopTimeStr() {
        return DateUtil.formatDate(stopTime);
    }
    public void setStopTimeStr(String stopTime) {
        this.stopTime = DateUtil.parseDateLong(stopTime + " 23:59:59");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID", unique = true, nullable = false)
    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "CHILDID")
    public Long getChildId() {
        return childId;
    }
    public void setChildId(Long childId) {
        this.childId = childId;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "LOOKNUM")
    public Integer getLookNum() {
        return lookNum;
    }
    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }
    @Column(name = "PARTYTIME")
    public String getPartyTime() {
        return partyTime;
    }
    public void setPartyTime(String partyTime) {
        this.partyTime = partyTime;
    }
    @Column(name = "STARTTIME")
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    @Column(name = "STOPTIME")
    public Long getStopTime() {
        return stopTime;
    }
    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name = "ISBEE")
    public Integer getIsBee() {
        return isBee;
    }
    public void setIsBee(Integer isBee) {
        this.isBee = isBee;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
