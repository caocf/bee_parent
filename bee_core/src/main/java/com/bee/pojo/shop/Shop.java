package com.bee.pojo.shop;

import com.bee.commons.Consts;
import com.bee.pojo.Area;
import com.bee.pojo.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.commons.utils.StringUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <b>商家数据库实体</b>
 *
 * v1.0.5
 * 增加字段
 * address, isFreeParking, isFood, isInvoice
 * 删除字段
 * isBack, phone, sortTime, remark, linkName
 *
 * v1.1.0
 * 增加字段
 * isBeeShop
 *
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_SHOP")
@JsonIgnoreProperties(value = {"admins"})
public class Shop implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -3492061204002404978L;

    // 主键
    private Long sid;
    // 商家标识
    private String identity;
    // 名字
    private String name;
    // 所属地区
    private Area area;
    // 类型
    private Integer type;
    // 状态
    private Integer status;
    // 商家管理员
    private Set<ShopUser> admins = new HashSet<>(0);
    // 最低价格
    private Double price;
    // 地址(模糊地址)
    private String addr;
    // 经纬度
    private Long lon;
    private Long lat;
    // 创建时间
    private Long createTime;
    // 权重
    private Integer sort;
    // 推荐
    private Integer recommend;
    // 修改时间
    private Long updateTime;

    /**
     * 商家营业时间
     */
    private String serviceTime;

    /**
     * 以下v1.0.5提供
     */
    // 详细地址
    private String address;
    // 是否提供刷卡
    private Integer isPosCard;
    // 是否提供免费停车
    private Integer isFreeParking;
    // 是否提供餐饮
    private Integer isFood;
    // 是否提供发票
    private Integer isInvoice;

    /**
     * v1.1.1 增加直营店
     */
    // 直营店
    private Integer isBeeShop;

    public Shop() {}
    public Shop(Long sid) {
        this.sid = sid;
    }

    @Transient
    public String getPriceStr() {
        if(null == getPrice() || getPrice() <= 0) {
            return "暂无价格";
        }
        return getPrice().toString();
    }

    @Transient
    public String getTypeStr() {
        return Consts.Shop.Type.Select().get(getType());
    }

    @Transient
    public String getStatusStr() {
        String status = "";
        if(getStatus() == Consts.Shop.Status.Run) {
            status = "运营中";
        } else if (getStatus() == Consts.Shop.Status.Pause) {
            status = "商家关闭中";
        } else if(getStatus() == Consts.Shop.Status.Close) {
            status = "关闭中";
        }
        return status;
    }

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDate(createTime);
    }

    @Transient
    public String getStartServiceTimeHour() {
        if (StringUtil.isNull(serviceTime)) {
            return "13";
        }
        return serviceTime.substring(0, serviceTime.indexOf(":"));
    }

    @Transient
    public String getStartServiceTimeMinute() {
        if (StringUtil.isNull(serviceTime)) {
            return "30";
        }
        return serviceTime.substring(serviceTime.indexOf(":") + 1, serviceTime.indexOf("-"));
    }

    @Transient
    public String getEndServiceTimeHour() {
        if (StringUtil.isNull(serviceTime)) {
            return "0";
        }
        return serviceTime.substring(serviceTime.indexOf("-") + 1, serviceTime.lastIndexOf(":"));
    }

    @Transient
    public String getEndServiceTimeMinute() {
        if (StringUtil.isNull(serviceTime)) {
            return "30";
        }
        return serviceTime.substring(serviceTime.lastIndexOf(":") + 1, serviceTime.length());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SID", unique = true, nullable = false)
    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    @Column(name = "IDENTITY")
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "AREA")
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "ADDR")
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name = "RECOMMEND")
    public Integer getRecommend() {
        return recommend;
    }
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "LON")
    public Long getLon() {
        return lon;
    }
    public void setLon(Long lon) {
        this.lon = lon;
    }
    @Column(name = "LAT")
    public Long getLat() {
        return lat;
    }
    public void setLat(Long lat) {
        this.lat = lat;
    }
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "shop")
    public Set<ShopUser> getAdmins() {
        return admins;
    }
    public void setAdmins(Set<ShopUser> admins) {
        this.admins = admins;
    }
    @Column(name = "UPDATETIME")
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    @Column(name = "SERVICETIME")
    public String getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "ISFREEPARKING")
    public Integer getIsFreeParking() {
        return isFreeParking;
    }
    public void setIsFreeParking(Integer isFreeParking) {
        this.isFreeParking = isFreeParking;
    }
    @Column(name = "ISFOOD")
    public Integer getIsFood() {
        return isFood;
    }
    public void setIsFood(Integer isFood) {
        this.isFood = isFood;
    }
    @Column(name = "ISINVOICE")
    public Integer getIsInvoice() {
        return isInvoice;
    }
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }
    @Column(name = "ISPOSCARD")
    public Integer getIsPosCard() {
        return isPosCard;
    }
    public void setIsPosCard(Integer isPosCard) {
        this.isPosCard = isPosCard;
    }
    @Column(name = "ISBEESHOP")
    public Integer getIsBeeShop() {
        return isBeeShop;
    }
    public void setIsBeeShop(Integer isBeeShop) {
        this.isBeeShop = isBeeShop;
    }
}
