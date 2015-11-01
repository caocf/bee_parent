package com.bee.admin.controller.stat;

import com.bee.admin.params.charts.*;
import com.bee.services.stat.IUserStatService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.security.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/5/7.
 */
@Auth
@Controller
@RequestMapping("/admin/stat/user")
public class AdminUserStatController {

    @Autowired
    private IUserStatService userStatService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String statUserReg() {
        return "stat/StatUser";
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
        title.setText(day + "天用户登录和注册统计");
        chart.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setTrigger("item");
        chart.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setData(new String[] {"登录", "注册"});
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
        series1.setName("登录");
        series1.setData(userStatService.statUserLogin(day, DateUtil.ONE_DAY_TIME));
        Series series2 = new Series();
        series2.setType("bar");
        series2.setName("注册");
        series2.setData(userStatService.statUserRegStat(day, DateUtil.ONE_DAY_TIME));

        chart.setSeries(new Series[] {series1, series2});

        return chart;
    }
}
