package com.bee.busi.controller.find;

import com.bee.commons.Codes;
import com.bee.domain.params.find.FindSaveParam;
import com.bee.pojo.find.Find;
import com.bee.services.find.busi.IFindBusiService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/25.
 */
@RestController
@RequestMapping("/find")
public class FindController {

    @Autowired
    private IFindBusiService findBusiService;

    /**
     * 保存发现
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response saveFind(FindSaveParam params) {
        Response res = new Response();
        if (StringUtil.checkIllegalChar(params.getContent())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容不合法,请修改");
            return res;
        }
        // 判断是否受限制商户
        if (params.getUid() == 351) {
            res.setCode(Codes.Error);
            res.setMsg("你的账户已被管理员限制");
            return res;
        }
        try {
            findBusiService.saveFind(params);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("保存失败,请重试");
        }
        return res;
    }



}
