package com.bee.app.travel;

import com.bee.app.travel.bean.GPS;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.DateUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by suntongwei on 16/1/18.
 */
public class TravelGpsCache {

    private Map<Long, GPS> cache = new ConcurrentHashMap<>();

    public void addGPS(GPS gps) {
        if (cache.containsKey(gps.getUser().getUid())) {
            cache.remove(gps.getUser().getUid());
        }
        cache.put(gps.getUser().getUid(), gps);
    }

    public List<GPS> getGPS(List<User> users) {
        List<GPS> result = new ArrayList<>();
        for (User user : users) {
            if (cache.containsKey(user.getUid())) {
                result.add(cache.get(user.getUid()));
            }
        }
        return result;
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(DateUtil.ONE_HOUR_TIME);
                        Long time = System.currentTimeMillis();
                        for (Iterator<Long> it = cache.keySet().iterator(); it.hasNext(); ) {
                            Long key = it.next();
                            GPS gps = cache.get(key);
                            if (time - gps.getCreateTime() > DateUtil.ONE_HOUR_TIME) {
                                cache.remove(key);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static TravelGpsCache ourInstance = new TravelGpsCache();
    public static TravelGpsCache getInstance() {
        return ourInstance;
    }
    private TravelGpsCache() {
        init();
    }
}
