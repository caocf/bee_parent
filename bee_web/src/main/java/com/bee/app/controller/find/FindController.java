package com.bee.app.controller.find;

import com.bee.client.params.find.FindListRequest;
import com.bee.modal.FindListItem;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/10.
 */
@RestController
@RequestMapping("/find")
public class FindController {

    @Autowired
    private IFindService findService;

    /**
     * 发现列表
     *
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<FindListItem> queryFindList(FindListRequest req) {
        return findService.queryAppFindList(req);
    }

}
