package com.bee.services.user.impl;

import com.bee.dao.user.UserFriendDao;
import com.bee.pojo.user.User;
import com.bee.pojo.user.UserFriend;
import com.bee.services.user.IFriendService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/5/11.
 */
@Service
public class FriendService implements IFriendService {

    @Autowired
    private UserFriendDao userFriendDao;

    @Override
    @Transactional
    public void addFriend(long uid1, long uid2) throws DataRunException {
        try {
            UserFriend one = new UserFriend();
            one.setUser(new User(uid1));
            one.setFriend(new User(uid2));
            userFriendDao.save(one);
            UserFriend two = new UserFriend();
            two.setUser(new User(uid2));
            two.setFriend(new User(uid1));
            userFriendDao.save(two);
        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public boolean isFriend(long uid, long uid2) {
        return userFriendDao.getUserFriend(uid, uid2) != null;
    }
}
