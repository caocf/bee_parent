package com.bee.admin.controller.stat;

import com.bee.admin.params.charts.*;
import com.bee.services.stat.IOrderStatService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/10/25.
 */
@Auth
@Controller
@RequestMapping("/admin/stat/order")
public class AdminOrderStatController {

    @Autowired
    private IOrderStatService orderStatService;


    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String statOrderPage() {
        return "stat/StatOrder";
    }


    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public Chart queryUserStat() {

        int day = 30;

        Chart chart = new Chart();

        Title title = new Title();
        title.setText(day + "天完成订单统计");
        chart.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger("item");
        chart.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setData(new String[] {"完成订单"});
        chart.setLegend(legend);

        ToolBox toolBox = new ToolBox();
        toolBox.setShow(true);
        Feature feature = new Feature();
        SaveAsImage saveAsImage = new SaveAsImage();
        saveAsImage.setShow(true);
        feature.setSaveAsImage(saveAsImage);
        toolBox.setFeature(feature);
        chart.setToolbox(toolBox);

        Axis xAxis = new Axis();
        xAxis.setType("category");
        String[] xAxisDatas = new String[day];
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis() - (day * DateUtil.ONE_DAY_TIME));
        for (int i = 0; i < day; i++) {
            if (i != 0) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            xAxisDatas[i] = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        }
        xAxis.setData(xAxisDatas);
        chart.setxAxis(new Axis[] {xAxis});

        Axis yAxis = new Axis();
        yAxis.setType("value");
        chart.setyAxis(new Axis[] {yAxis});

        Series series1 = new Series();
        series1.setType("line");
        series1.setName("完成订单");
        series1.setData(orderStatService.statFinishOrder(0, day, DateUtil.ONE_DAY_TIME));

        chart.setSeries(new Series[] {series1});

        return chart;
    }


}
