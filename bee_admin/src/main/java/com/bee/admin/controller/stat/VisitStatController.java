package com.bee.admin.controller.stat;

import com.bee.admin.params.charts.*;
import com.bee.admin.params.stat.StatClickParam;
import com.bee.admin.services.stat.IUserStatService;
import com.bee.commons.AuthName;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/11/14.
 */
@Auth(name = AuthName.Stat)
@Controller
@RequestMapping("/stat/visit")
public class VisitStatController {

    @Autowired
    private IUserStatService userStatService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "stat/StatVisit";
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
        title.setText(day + "天用户登录次数统计");
        chart.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger("item");
        chart.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setData(new String[] {"用户登录"});
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
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.setTimeInMillis(cal.getTimeInMillis() - (day * DateUtil.ONE_DAY_TIME));
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
        series1.setName("用户登录");
                series1.setData(userStatService.statUserLogin(day, DateUtil.ONE_DAY_TIME));

        chart.setSeries(new Series[] {series1});

        return chart;
    }

    /**
     * 查看某天详细登录统计
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Chart queryLoginDetailStat(StatClickParam params) {

        // 计算统计时间
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_MONTH) < Integer.valueOf(params.getName())) {
            cal.add(Calendar.MONTH, -1);
        }
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(params.getName()));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 组装CHART
        Chart chart = new Chart();

        Title title = new Title();
        title.setText("24小时用户登录统计");
        title.setSubtext(DateUtil.formatDate(cal.getTimeInMillis()));
        chart.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger("item");
        chart.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setData(new String[] {"登录"});
        chart.setLegend(legend);

        ToolBox toolBox = new ToolBox();
        toolBox.setShow(true);
        Feature feature = new Feature();
        SaveAsImage saveAsImage = new SaveAsImage();
        saveAsImage.setShow(true);
        feature.setSaveAsImage(saveAsImage);
        toolBox.setFeature(feature);
        chart.setToolbox(toolBox);

        Double[] result = userStatService.statUserLoginDetail(
                cal.getTimeInMillis(), (cal.getTimeInMillis() + DateUtil.ONE_DAY_TIME - 1));

        Axis xAxis = new Axis();
        xAxis.setType("category");
        xAxis.setBoundaryGap(false);
        String[] xAxisDatas = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            xAxisDatas[i] = String.valueOf(i + 1);
        }
        xAxis.setData(xAxisDatas);
        chart.setxAxis(new Axis[] {xAxis});

        Axis yAxis = new Axis();
        yAxis.setType("value");
        chart.setyAxis(new Axis[] {yAxis});

        Series series1 = new Series();
        series1.setType("line");
        series1.setName("登录");
        series1.setData(result);

        AreaStyle areaStyle = new AreaStyle();
        areaStyle.setType("default");
        Normal normal = new Normal();
        normal.setAreaStyle(areaStyle);
        ItemStyle itemStyle = new ItemStyle();
        itemStyle.setNormal(normal);
        series1.setItemStyle(itemStyle);

        chart.setSeries(new Series[] {series1});

        return chart;
    }
}
