package com.bee.app.controller.finds;

import com.bee.domain.params.FindListParam;
import com.bee.modal.FindListItem;
import com.bee.services.find.app.IFindAppService;
import com.qsd.framework.spring.PagingResult;
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
    public PagingResult<FindListItem> queryFindList(FindListParam param) {
        return findService.queryFindList(param);
    }


}
