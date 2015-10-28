package com.bee.services.store;

import com.bee.admin.params.store.GoodsRequest;
import com.bee.app.model.store.GoodsListItem;
import com.bee.app.params.store.GoodsQueryRequest;
import com.bee.commons.Consts;
import com.bee.pojo.store.Goods;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/10/21.
 */
public interface IGoodsService {

    /**
     * 【A端】查询商品列表
     *
     * @return
     */
    public PagingResult<Goods> getGoodsList(GoodsRequest request);

    /**
     * 【A端】查询单个商品
     *
     * @param goodsId
     * @return
     */
    public Goods getGoodsById(long goodsId);

    /**
     * 【C端】查询商品列表
     *
     * @param request
     * @return
     */
    public PagingResult<GoodsListItem> queryGoodsList(GoodsQueryRequest request);
}
