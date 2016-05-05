package com.bee.app.controller.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.domain.response.ShopResponse;
import com.bee.domain.response.shop.ShopListResponse;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.stat.ShopStat;
import com.bee.pojo.user.User;
import com.bee.services.shop.app.IShopAppService;
import com.bee.services.stat.app.IShopStatAppService;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>商家控制器</b>
 *
 * v1.0.5
 * 1. 删除原商家出勤接口信息
 *
 * Created by suntongwei on 15/11/22.
 */
@RestController
@RequestMapping("/v1/shop")
public class ShopController {

    @Autowired
    private IShopAppService shopAppService;
    @Autowired
    private IShopStatAppService shopStatAppService;

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<ShopListItem> queryShopList(ShopListRequest req) {
        ResponsePaging<ShopListItem> res = new ResponsePaging<>();
        res.setResult(shopAppService.queryShopList(req));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 查询推广商家列表
     *
     * @return
     */
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public ResponseArray<ShopListItem> queryShopRecommend() {
        ResponseArray<ShopListItem> res = new ResponseArray<>();
        res.setResult(shopAppService.queryRecommendShop());
        res.setCode(Codes.Success);
        return res;
    }


    /**
     * 查询商家
     *
     * @see V2ShopController#getShopItem(Long, Long)
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ShopResponse getShopItem(@PathVariable Long id, Long uid) {
        ShopResponse res = new ShopResponse();
        // 增加商家浏览统计
        try {
            shopStatAppService.addShopStat(new Shop(id),
                    null == uid || uid < 0 ? new User(0l) : new User(uid));
        } catch (DataRunException e) {}

        // 获取商家信息
        res.setShopItem(shopAppService.getShopItem(id));

        // v1.0.5删除
        // 获取商家滚动相册
        // res.setShopImages(shopImageAppService.queryShopImage(id));
        // 加入商家出勤表
        // res.setShopAttends(shopAttendAppService.getShopAttendByShopId(id));

        res.setCode(Codes.Success);
        return res;
    }

}
