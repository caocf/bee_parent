package com.bee.services.store.impl;

import com.bee.admin.params.store.GoodsRequest;
import com.bee.app.model.store.GoodsListItem;
import com.bee.app.params.store.GoodsQueryRequest;
import com.bee.dao.store.GoodsDao;
import com.bee.pojo.store.Goods;
import com.bee.services.store.IGoodsService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/10/21.
 */
@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 【A端】查询商品列表
     *
     * @return
     */
    public PagingResult<Goods> getGoodsList(GoodsRequest request) {
        return goodsDao.getGoodsList(request);
    }


    /**
     * 【A端】查询单个商品
     *
     * @param goodsId
     * @return
     */
    public Goods getGoodsById(long goodsId) {
        return goodsDao.findById(goodsId);
    }


    /**
     * 【C端】查询商品列表
     *
     * @param request
     * @return
     */
    @Override
    public PagingResult<GoodsListItem> queryGoodsList(GoodsQueryRequest request) {
        return goodsDao.queryGoodsList(request);
    }
}
