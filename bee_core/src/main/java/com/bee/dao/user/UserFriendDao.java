package com.bee.dao.user;

import com.bee.commons.SQL;
import com.bee.pojo.user.User;
import com.bee.pojo.user.UserFriend;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 15/4/30.
 */
@Repository
public class UserFriendDao extends JpaDaoSupport<UserFriend, Long> {

    public List<User> getFriendByUser(long uid) {
        List<UserFriend> userFriends = findByParams(SQL.User.Friend.getFriendByUser, uid, uid);
        if(null == userFriends || userFriends.isEmpty()) {
            return null;
        }
        List<User> users = new ArrayList<User>();
        for(UserFriend friend: userFriends) {
            if(friend.getUser().getUid() == uid) {
                users.add(friend.getFriend());
            } else {
                users.add(friend.getUser());
            }
        }
        return users;
    }


    public UserFriend getUserFriend(long uid1, long uid2) {
        return findFirstByParams(SQL.User.Friend.getUserFriend, uid1, uid2);
    }
}
