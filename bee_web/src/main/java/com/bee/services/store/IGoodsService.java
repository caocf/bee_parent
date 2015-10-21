package com.bee.services.store;

import com.bee.app.model.store.GoodsListItem;
import com.bee.app.params.store.GoodsQueryRequest;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/10/21.
 */
public interface IGoodsService {

    /**
     * 【C端】查询商品列表
     *
     * @param request
     * @return
     */
    public PagingResult<GoodsListItem> queryGoodsList(GoodsQueryRequest request);
}
