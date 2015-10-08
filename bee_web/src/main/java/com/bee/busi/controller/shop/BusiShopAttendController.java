package com.bee.busi.controller.shop;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.bee.commons.Codes;
import com.bee.services.shop.IShopAttendService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@RestController
@RequestMapping("/busi/shop/{sid}/attend")
public class BusiShopAttendController {

    @Autowired
    private IShopAttendService shopAttendService;

    /**
     * 保存发布出勤表
     *
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse saveShopAttend(@PathVariable Long sid, ShopAttendSaveRequest req) {
        BaseResponse res = new BaseResponse();
        try {
            req.setShopId(sid);
            shopAttendService.saveShopAttend(req);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存失败，请重试");
        }
        return res;
    }

    /**
     * 查询商家出勤表
     *
     * @param sid 商家ID
     * @param attendTime 出勤时间
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<BusiShopAttend> getShopAttendByShopId(@PathVariable Long sid, Long attendTime) {
        return shopAttendService.getShopAttendByShopId(sid, attendTime);
    }
}
