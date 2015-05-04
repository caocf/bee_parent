package com.bee.app.controller.stat;

import com.qsd.framework.spring.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/5/4.
 */
@RestController
@RequestMapping("/stat/shop/{sid}")
public class StatShopController {

    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse visitShopStat(@PathVariable Long sid) {
        return null;
    }

    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public BaseResponse phoneCallStat(@PathVariable Long sid) {
        return null;
    }
}
