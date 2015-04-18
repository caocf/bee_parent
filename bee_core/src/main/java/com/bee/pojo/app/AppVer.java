package com.bee.pojo.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	 * 版本号
	 */
	private Integer ver;
	/**
	 * 版本号（字符）
	 */
	private String verStr;
	/**
	 * 下载地址
	 */
	private String path;
    /**
     * 发布日期
     */
    private Long createTime;
	
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
}
