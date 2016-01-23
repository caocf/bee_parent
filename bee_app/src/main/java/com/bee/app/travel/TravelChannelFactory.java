package com.bee.app.travel;

import com.bee.app.travel.bean.Channel;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.DateUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by suntongwei on 16/1/18.
 */
public class TravelChannelFactory {


    private Map<Long, Channel> channelCache = new ConcurrentHashMap<>();

    public void addChannel(Channel channel) throws RuntimeException {
        if (channelCache.containsKey(channel.getChannelId())) {
            throw new RuntimeException();
        }
        channelCache.put(channel.getChannelId(), channel);
    }

    public List<Channel> getChannel() {
        return new ArrayList<>(channelCache.values());
    }

    public Channel getChannel(Long channelId) {
        return channelCache.get(channelId);
    }

    public void joinChannel(Long channelId, User user) throws RuntimeException {
        if (!channelCache.containsKey(channelId)) {
            throw new RuntimeException();
        }
        channelCache.get(channelId).getUsers().add(user);
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(DateUtil.ONE_DAY_TIME);
                        Long time = System.currentTimeMillis();
                        for (Iterator<Long> it = channelCache.keySet().iterator(); it.hasNext();) {
                            Long key = it.next();
                            Channel channel = channelCache.get(key);
                            if (time - channel.getCreateTime() > DateUtil.ONE_DAY_TIME
                                    && channel.getCreateTime() != 0) {
                                channelCache.remove(key);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static TravelChannelFactory ourInstance = new TravelChannelFactory();
    public static TravelChannelFactory getInstance() {
        return ourInstance;
    }
    private TravelChannelFactory() {
        init();
        Channel channel = new Channel();
        channel.setChannelId(1000l);
        channel.setName("测试频道");
        channel.setCreateTime(0l);
        addChannel(channel);
    }
}
