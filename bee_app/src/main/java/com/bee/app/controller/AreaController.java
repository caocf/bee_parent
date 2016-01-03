package com.bee.app.controller;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.pojo.Area;
import com.bee.pojo.SystemConfig;
import com.bee.services.system.IAreaService;
import com.bee.services.system.ISystemConfigService;
import com.bee.services.system.app.IAreaAppService;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/25.
 */
@RestController
@RequestMapping(value = "/v1/area")
public class AreaController {

    @Autowired
    private IAreaAppService areaAppService;
    @Autowired
    private ISystemConfigService systemConfigService;

    /**
     * 获取全部地区列表
     *
     * @param lastId 最后地区ID,作为版本号
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<Area> getAreaAll(long lastId) {
        ResponseArray<Area> res = new ResponseArray<>();
        SystemConfig config = systemConfigService.getConfig(Consts.Config.Area);
        // 如果客户端发送updateTime == 0,则拉取数据
        // 如果客户端版本低于系统配置版本也拉取数据
        if ((config != null && config.getFlag() > lastId) || lastId == 0) {
            res.setResult(areaAppService.getAreaByLastId(lastId));
        }
        res.setCode(Codes.Success);
        return res;
    }


}
