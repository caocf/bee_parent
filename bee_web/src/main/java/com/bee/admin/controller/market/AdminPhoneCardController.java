package com.bee.admin.controller.market;

import com.bee.admin.params.store.PhoneCardRequest;
import com.bee.commons.Codes;
import com.bee.pojo.store.PhoneCard;
import com.bee.services.store.IPhoneCardService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 手机充值卡控制器
 *
 * 注：关于goodsId，目前对应的goodsId,代表3个主键，1代表移动，2代表联通，3代表电信
 * 因没有对商品进行详细分类，暂时处理
 *
 * Created by suntongwei on 15/10/28.
 */
@Auth
@Controller
@RequestMapping("/admin/store/{goodsId}/phone")
public class AdminPhoneCardController {

    @Autowired
    private IPhoneCardService phoneCardService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(PhoneCardRequest req) {
        ModelAndView mav = new ModelAndView("market/PhoneList");
        mav.addObject("result", phoneCardService.queryPhoneCard(req));
        return mav;
    }

    /**
     * 增加手机充值卡
     *
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("market/PhoneNew");
        mav.addObject("action", "增加");
        return mav;
    }

    /**
     * 保存一个手机充值卡
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(PhoneCard phoneCard) {
        try {
            // 暂时使用移动运营商的字段代替
            long goodsId = phoneCard.getOperator();
            phoneCardService.savePhoneCard(goodsId, phoneCard);
            return index(new PhoneCardRequest());
        } catch (DataRunException e) {
            e.printStackTrace();
            return create().addObject("msg", "保存失败").addObject("phoneCard", phoneCard);
        }
    }

    /**
     * 修改手机充值卡
     *
     * @return
     */
    @RequestMapping(value = "/{pcId}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long pcId) {
        ModelAndView mav = new ModelAndView("market/PhoneNew");
        mav.addObject("action", "修改");
        mav.addObject("phoneCard", phoneCardService.getPhoneCardById(pcId));
        return mav;
    }

    /**
     * 修改手机充值卡
     *
     * @return
     */
    @RequestMapping(value = "/{pcId}", method = RequestMethod.PUT)
    public ModelAndView update(PhoneCard phoneCard) {
        try {
            phoneCardService.updatePhoneCard(phoneCard);
            return index(new PhoneCardRequest());
        } catch (DataRunException e) {
            String errorMsg = "保存失败";
            if (e.getErrorCode() == Codes.Store.PhoneCard.PhoneCardIsUsed) {
                errorMsg = "手机卡已被兑换，无法修改";
            }
            return edit(phoneCard.getPcId()).addObject("msg", errorMsg).addObject("phoneCard", phoneCard);
        }
    }

    /**
     *
     * @param pcId
     * @return
     */
    @RequestMapping(value = "/{pcId}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable Long pcId) {
        try {
            phoneCardService.deletePhoneCard(0, pcId);
            return index(new PhoneCardRequest());
        } catch (DataRunException e) {
            String errorMsg = "保存失败";
            if (e.getErrorCode() == Codes.Store.PhoneCard.NumberEnough) {
                errorMsg = "已经没有足够的库存";
            }
            return index(new PhoneCardRequest()).addObject("msg", errorMsg);
        }

    }

}
