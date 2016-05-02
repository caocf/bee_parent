package com.bee.pojo.find;

import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 15/6/10.
 */
@Entity
@Table(name = "TB_FIND")
public class Find implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1432017715956772511L;

    // 主键
    private Long fid;
    // 发现类型
    private Integer type;
    // 所属用户
    private User user;
    // 创建时间
    private Long createTime;
    // 文字
    private String content;
    // 所属商家
    private Shop shop;
    // 发现图片
    private List<FindImage> findImages = new ArrayList<>(0);

    public Find() {}
    public Find(Long id) {
        fid = id;
    }

    @Transient
    public String getTypeStr() {
        return Consts.Find.Type.Select().get(type);
    }
    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(createTime);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FID", unique = true, nullable = false)
    public Long getFid() {
        return fid;
    }
    public void setFid(Long fid) {
        this.fid = fid;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Lob
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "find")
    public List<FindImage> getFindImages() {
        return findImages;
    }
    public void setFindImages(List<FindImage> findImages) {
        this.findImages = findImages;
    }
}
