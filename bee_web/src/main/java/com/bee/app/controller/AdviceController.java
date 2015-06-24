package com.bee.app.controller;

import com.bee.commons.Codes;
import com.bee.pojo.Advice;
import com.bee.services.system.IAdviceService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/24.
 */
@RestController
@RequestMapping(value = "/advice")
public class AdviceController {

    @Autowired
    private IAdviceService adviceService;

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse addAdvice(Advice advice) {
        BaseResponse res = new BaseResponse();
        try {
            adviceService.saveAdvice(advice);
            res.setCode(Codes.Success);
        } catch(DataRunException e) {
            res.setCode(Codes.Error);
            e.printStackTrace();
        }
        return res;
    }

}
