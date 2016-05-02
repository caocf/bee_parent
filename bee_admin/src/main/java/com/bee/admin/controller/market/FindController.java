package com.bee.admin.controller.market;

import com.bee.commons.AuthName;
import com.bee.commons.Codes;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.find.Find;
import com.bee.services.find.admin.IFindAdminService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.annotation.Auth;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by suntongwei on 16/5/2.
 */
@Controller
@RequestMapping("/find")
public class FindController {

    public static final String FindIndex = "market/FindList";

    @Autowired
    private IFindAdminService findAdminService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return FindIndex;
    }

    /**
     * 查询发现信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ResponsePaging<Find> queryFindList(AdminRequestPaging param) {
        ResponsePaging<Find> res = new ResponsePaging<>();
        res.setResult(findAdminService.queryFindList(param));
        res.setCode(Codes.Success);
        return res;
    }


    /**
     * 删除发现
     *
     * @param findId 发现ID
     * @return
     */
    @Auth(name = AuthName.FindDelete)
    @ResponseBody
    @RequestMapping(value = "/{findId}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable Long findId) {
        Response res = new Response();
        try {
            findAdminService.delete(findId);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败");
        }
        return res;
    }
}
