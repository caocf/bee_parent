package com.bee.app.controller.finds;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.find.Find;
import com.bee.domain.params.find.FindListParam;
import com.bee.services.find.app.IFindAppService;
import com.qsd.framework.domain.response.ResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>FindController 发现控制器</b>
 *
 * @version v1
 * @since v1.1.0
 */
@RestController
@RequestMapping("/v1/find")
public class FindController {

    @Autowired
    private IFindAppService findService;


    /**
     * 发现列表
     *
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<Find> queryFindList(FindListParam param) {
        ResponsePaging<Find> res = new ResponsePaging<>();
        res.setResult(findService.queryFindList(param));
        res.setCode(Codes.Success);
        return res;
    }


}
