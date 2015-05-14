package com.bee.services.user;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/5/11.
 */
public interface IFriendService {

    /**
     *
     * @param uid1
     * @param uid2
     * @throws DataRunException
     */
    public void addFriend(long uid1, long uid2) throws DataRunException;

    /**
     * 判断是否是好友
     *
     * @param uid
     * @param uid2
     * @return
     */
    public boolean isFriend(long uid, long uid2);

    /**
     * 删除好友
     *
     * @param uid1
     * @param uid2
     * @throws DataRunException
     */
    public void deleteFriend(long uid1, long uid2) throws DataRunException;
}
