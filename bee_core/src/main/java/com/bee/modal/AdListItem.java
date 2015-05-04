package com.bee.modal;

/**
 * Created by suntongwei on 15/5/5.
 */
public class AdListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -5543371046285196506L;

    private Long adid;
    private String url;
    private Long shopId;

    public Long getAdid() {
        return adid;
    }

    public void setAdid(Long adid) {
        this.adid = adid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
