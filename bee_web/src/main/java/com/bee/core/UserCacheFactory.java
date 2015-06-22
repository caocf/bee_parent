package com.bee.core;

import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.bee.services.user.impl.UserService;
import com.qsd.framework.spring.SpringFactory;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by suntongwei on 15/6/19.
 */
public final class UserCacheFactory {

    // LOG
    private static final Logger Log = Logger.getLogger(UserCacheFactory.class);

    // 用户缓存
    private Map<String, User> cache = new ConcurrentHashMap<>();

    /**
     * 初始化
     */
    private void init() {
        Log.debug("初始化用户缓存，读取所有用户...");
        IUserService userService = SpringFactory.getBean(UserService.class);
        List<User> users = userService.getAllUser();
        for (User user : users) {
            cache.put(user.getIdentity(), user);
        }
    }

    public void put(User user) {
        cache.put(user.getIdentity(), user);
    }

    public User get(String key) {
        return cache.get(key);
    }

    public List<User> getUsers(String[] identity) {
        List<User> user = new ArrayList<>();
        for (String s : identity) {
            if (cache.containsKey(s)) {
                user.add(cache.get(s));
            }
        }
        return user;
    }

    private static UserCacheFactory ourInstance = new UserCacheFactory();
    public static UserCacheFactory getInstance() {
        return ourInstance;
    }
    private UserCacheFactory() {
        init();
    }
}
