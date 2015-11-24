package com.bee.app.controller;

import com.bee.commons.Codes;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by suntongwei on 15/11/24.
 */
@RestController
@RequestMapping("/v1")
public class AppController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/order/time", method = RequestMethod.GET)
    public ResponseArray<Long> getOrderTime(Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        ResponseArray<Long> res = new ResponseArray<>();
        res.setResult(new ArrayList<Long>());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        int minute = cal.get(Calendar.MINUTE);
        if (minute >= 45) {
            cal.add(Calendar.HOUR_OF_DAY, 1);
            cal.set(Calendar.MINUTE, 0);
        } else if (minute >= 30 && minute < 45) {
            cal.set(Calendar.MINUTE, 45);
        } else if (minute >= 15 && minute < 30) {
            cal.set(Calendar.MINUTE, 30);
        } else if (minute >=0 && minute < 15) {
            cal.set(Calendar.MINUTE, 15);
        }

        // 开始时间
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.AM_PM, startHour > 12 ? Calendar.PM : Calendar.AM);
        startTime.set(Calendar.HOUR_OF_DAY, startHour);
        startTime.set(Calendar.HOUR, startHour > 12 ? startHour - 12 : startHour);
        startTime.set(Calendar.MINUTE, startMinute);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);

        // 结束时间
        Calendar endTime = Calendar.getInstance();
        endTime.set(Calendar.AM_PM, endHour > 12 ? Calendar.PM : Calendar.AM);
        endTime.set(Calendar.HOUR_OF_DAY, endHour);
        endTime.set(Calendar.HOUR, endHour > 12 ? endHour - 12 : endHour);
        endTime.set(Calendar.MINUTE, endMinute);
        endTime.set(Calendar.SECOND, 0);
        endTime.set(Calendar.MILLISECOND, 0);

        if (cal.getTimeInMillis() < startTime.getTimeInMillis()
                && cal.getTimeInMillis() < endTime.getTimeInMillis()) {
            startTime.add(Calendar.DAY_OF_MONTH, -1);
        } else {
            endTime.add(Calendar.DAY_OF_MONTH, 1);
        }

        while (cal.getTimeInMillis() <= endTime.getTimeInMillis()) {
            if (cal.getTimeInMillis() < startTime.getTimeInMillis()) {
                cal.add(Calendar.MINUTE, 15);
                continue;
            }
            res.getResult().add(cal.getTimeInMillis());
            cal.add(Calendar.MINUTE, 15);
        }
        res.setCode(Codes.Success);
        return res;
    }


}
