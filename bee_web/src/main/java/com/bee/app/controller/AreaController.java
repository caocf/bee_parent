package com.bee.app.controller;

import com.bee.pojo.Area;
import com.bee.services.system.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 15/4/21.
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public List<Area> getAreaById(@PathVariable Long id) {
        return areaService.getAreaListById(id);
    }
}
