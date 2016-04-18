package com.bee.busi.controller.shop;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.domain.params.shop.ShopTecheeAttendParam;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.domain.response.ResponseObject;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 16/4/11.
 */
@RestController
@RequestMapping("/shop/{sid}/techee")
public class ShopTecheeController {

    @Autowired
    private IShopTecheeBusiService shopTecheeBusiService;

    /**
     * <b>查询商家出勤表</b>
     *
     * @param sid 商家ID
     * @return
     */
    @RequestMapping(value = "/attend", method = RequestMethod.GET)
    public ResponseArray<ShopTecheeAttend> queryShopTecheeAttend(@PathVariable Long sid) {
        ResponseArray res = new ResponseArray();
        ShopTecheeAttendParam param = new ShopTecheeAttendParam();
        param.setShopId(sid);
        res.setResult(shopTecheeBusiService.queryShopTecheeAttend(param));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 保存商家出勤表
     *
     * @param sid
     * @param attends
     * @return
     */
    @RequestMapping(value = "/attend", method = RequestMethod.POST)
    public Response submitAttend(@PathVariable Long sid, String attends) {
        Response res = new Response();
        if (StringUtil.isNull(attends)) {
            res.setCode(Codes.ParamsError);
            res.setMsg("参数错误");
            return res;
        }
        try {
            shopTecheeBusiService.saveTecheeAttend(sid, attends);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("发布出勤表失败");
        }
        return res;
    }

}
