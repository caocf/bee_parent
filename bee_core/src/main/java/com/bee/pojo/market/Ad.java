package com.bee.pojo.market;

import com.bee.commons.Consts;
import com.bee.pojo.Area;
import com.bee.pojo.shop.Shop;
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
    private String url;
	private Integer type;
	private Integer sort;
    private Shop shop;
	private Area area;
	private Long createTime;
    private Long startTime;
	private Long stopTime;
	
	@Transient
	public String getTypeStr() {
		if(type == Consts.Ad.Type.Home) {
			return "首页界面";
		} else if(type == Consts.Ad.Type.Party) {
			return "活动界面";
		}
		return "";
	}

    @Transient
    public String getStartTimeStr() {
        return DateUtil.formatDateTime(startTime);
    }
	
	@Transient
	public String getStopTimeStr() {
		if(null == stopTime) {
			return "";
		}
		return DateUtil.formatDateTime(stopTime);
	}

    @Transient
    public String getStatus() {
        return System.currentTimeMillis() - getStopTime() > 0 ?
                "<span class='text-danger'>未显示</span>" : "<span class='text-success'>显示</span>";
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
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
