package com.bee.app.controller.store;

import com.bee.app.model.store.GoodsListItem;
import com.bee.app.params.store.GoodsQueryRequest;
import com.bee.services.store.IGoodsService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/10/21.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询积分商城商品
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<GoodsListItem> queryGoodsList(GoodsQueryRequest request) {
        return goodsService.queryGoodsList(request);
    }

}
