package com.bee.admin.controller.stat;

import com.bee.admin.params.charts.*;
import com.bee.commons.AuthName;
import com.bee.domain.modal.admin.stat.ShopCountStat;
import com.bee.services.stat.admin.IShopStatAdminService;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by suntongwei on 16/5/7.
 */
@Auth(name = AuthName.Stat)
@Controller
@RequestMapping("/stat/shop")
public class ShopStatController {

    public static final String ShopStatView = "stat/StatShop";

    @Autowired
    private IShopStatAdminService shopStatAdminService;

    /**
     * 商家统计
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return ShopStatView;
    }

    /**
     * 统计商家访问
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public Chart queryShopStat() {
        Chart chart = new Chart();

        Title title = new Title();
        title.setText("商家访问次数统计");
        title.setSubtext("30天商家访问次数");
        chart.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger("axis");
        AxisPointer axisPointer = new AxisPointer();
        axisPointer.setType("shadow");
        tooltip.setAxisPointer(axisPointer);
        chart.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setData(new String[] {"访问次数"});
        chart.setLegend(legend);

        Grid grid = new Grid();
        grid.setLeft("5");
        grid.setRight("10");
        grid.setBottom("5");
        grid.setContainLabel(true);
        chart.setGrid(grid);

        ToolBox toolBox = new ToolBox();
        toolBox.setShow(true);
        Feature feature = new Feature();
        SaveAsImage saveAsImage = new SaveAsImage();
        saveAsImage.setShow(true);
        feature.setSaveAsImage(saveAsImage);
        toolBox.setFeature(feature);
        chart.setToolbox(toolBox);

        Axis xAxis = new Axis();
        xAxis.setType("value");
        xAxis.setPosition("top");
        chart.setxAxis(new Axis[] {xAxis});

        List<ShopCountStat> result = shopStatAdminService.statShopVisitCount();
        String[] names = new String[result.size()];
        Double[] counts = new Double[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ShopCountStat item = result.get(i);
            names[i] = item.getName();
            counts[i] = item.getCount();
        }

        Axis yAxis = new Axis();
        yAxis.setType("category");
        yAxis.setData(names);
        chart.setyAxis(new Axis[] {yAxis});

        Series series1 = new Series();
        series1.setType("bar");
        series1.setName("访问次数");
        series1.setData(counts);
        chart.setSeries(new Series[] {series1});

        chart.setColor(new String[] {"#438EB9"});

        return chart;
    }

}
