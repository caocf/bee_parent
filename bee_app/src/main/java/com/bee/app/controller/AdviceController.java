package com.bee.app.controller;

import com.bee.commons.Codes;
import com.bee.pojo.Advice;
import com.bee.services.system.app.IAdviceAppService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/21.
 */
@RestController
@RequestMapping(value = "/v1/advice")
public class AdviceController {

    @Autowired
    private IAdviceAppService adviceAppService;

    /**
     * 提交建议
     *
     * @param advice
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response addAdvice(Advice advice) {
        Response res = new Response();
        if (StringUtil.checkIllegalChar(advice.getMsg(), advice.getPhone())) {
            res.setCode(Codes.Error);
            res.setMsg("输入内容不合法，请重新输入");
            return res;
        }
        try {
            adviceAppService.addAdvice(advice);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            res.setCode(Codes.Error);
        }
        return res;
    }

}
