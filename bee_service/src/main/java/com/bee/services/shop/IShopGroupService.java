package com.bee.services.shop;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopGroupService {

    /**
     * 删除一个分组
     *
     * @param shopGroupId
     * @throws DataRunException
     */
    void deleteShopGroup(long shopId, long shopGroupId) throws DataRunException;
}
