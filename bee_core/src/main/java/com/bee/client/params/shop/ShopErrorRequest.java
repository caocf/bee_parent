package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * 
 */
public class ShopErrorRequest extends PagingRequest {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1484526019973061979L;

	/**
	 * 页数
	 */
	private Long shopId;
	private String shopName;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 状态
	 */
	private Integer status;


    @Override
    public Integer getMaxRows() {
        return 50;
    }

    public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
