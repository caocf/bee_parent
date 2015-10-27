package com.bee.pojo;

import com.bee.commons.Consts;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

@Entity
@Table(name = "TB_APP_VER")
public class AppVer implements java.io.Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1281023485552161054L;

    /**
     * 主键
     */
    private Long avid;
    /**
     * Android和IOS
     * @see com.bee.commons.Consts.AppType
     */
    private Integer type;
    /**
     * 版本号
     */
    private Integer ver;
    /**
     * 版本号（字符）
     */
    private String verStr;
    /**
     * 本地地址
     */
    private String path;
    /**
     * 下载地址
     */
    private String url;
    /**
     * 发布日期
     */
    private Long createTime;
    /**
     * 说明
     */
    private String remark;

    @Transient
    public String getTypeStr() {
        return Consts.GetAppVerSelect().get(type);
    }

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(getCreateTime());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AVID", unique = true, nullable = false)
    public Long getAvid() {
        return avid;
    }
    public void setAvid(Long avid) {
        this.avid = avid;
    }
    @Column(name = "VER")
    public Integer getVer() {
        return ver;
    }
    public void setVer(Integer ver) {
        this.ver = ver;
    }
    @Column(name = "VERSTR")
    public String getVerStr() {
        return verStr;
    }
    public void setVerStr(String verStr) {
        this.verStr = verStr;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
