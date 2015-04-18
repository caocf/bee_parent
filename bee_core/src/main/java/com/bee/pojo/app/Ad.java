package com.bee.pojo.app;

import com.bee.pojo.Area;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

@Entity
@Table(name = "TB_AD")
public class Ad implements java.io.Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1360807261869908753L;

	private Long adid;
	private String path;
	private Integer type;
	private Integer sort;
	private Long sid;
	private Area area;
	private Long createTime;
	private Long stopTime;
	
	@Transient
	public String getTypeStr() {
		if(type == 1) {
			return "首页界面";
		} else if(type == 2) {
			return "活动界面";
		}
		return "";
	}
	
	@Transient
	public String getStopTimeStr() {
		if(null == stopTime) {
			return "";
		}
		return DateUtil.formatDateTime(stopTime);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADID", unique = true, nullable = false)
	public Long getAdid() {
		return adid;
	}
	public void setAdid(Long adid) {
		this.adid = adid;
	}
	@Column(name = "PATH")
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Column(name = "TYPE")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "AREA")
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	@Column(name = "CREATETIME")
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
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
	@Column(name = "SID")
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
}
