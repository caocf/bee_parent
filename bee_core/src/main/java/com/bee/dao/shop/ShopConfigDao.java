package com.bee.dao.shop;

import com.bee.commons.Consts;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopConfig;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 16/4/23.
 */
@Repository
public class ShopConfigDao extends JpaDaoSupport<ShopConfig, Long> {

    public static final String GetShopConfigByShopId = "From ShopConfig A where A.shop.sid = ?";

    /**
     * 获取商家配置信息
     *
     * @param shopId
     * @return
     */
    public ShopConfig getShopConfigByShopId(long shopId) {
        return findFirstByParams(GetShopConfigByShopId, shopId);
    }

    /**
     * 返回一个默认值的ShopConfig
     *
     * @param shopId
     * @return
     */
    public ShopConfig getDefaultShopConfig(long shopId) {
        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setShop(new Shop(shopId));
        shopConfig.setHasVideo(Consts.False);
        save(shopConfig);
        return shopConfig;
    }

    /**
     * 查询所有ShopConfig
     *
     * @return
     */
    public static final String QueryShopConfig = "From ShopConfig A left join fetch A.shop B where 1=1";
    public PagingResult<ShopConfig> queryShopConfig(AdminRequestPaging param) {
        HQLEntity entity = new HQLEntity(QueryShopConfig);
        entity.setPaging(param);
        return queryWithPaging(entity);
    }

}
