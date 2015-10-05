package com.bee.dao.user;

import com.bee.app.model.user.UserInfo;
import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.SQL;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Repository
public class UserDao extends JpaDaoSupport<User, Long> {

    public User getUserByAccount(String account) {
        return findFirstByParams(SQL.User.queryUserByAccount, account);
    }

    /**
     * 根据参数查询用户列表
     *
     * @param req
     * @return
     */
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.queryUserListByParams);
        if(req.getType() != null) {
            sb.append(" and A.type = ?");
            entity.setParams(req.getType());
        }
        sb.append(SQL.User.queryUserListByParamsSort);
        entity.setEntity(sb.toString());
        entity.setPaging(req);
        return queryWithPaging(entity);
    }

    /**
     * 查询用户实时信息
     *
     * @param uid
     * @return
     */
    public UserInfo queryUserInfo(long uid) {
        return findFirstConverByParams(SQL.User.QueryUserInfo, new QueryDataConver<UserInfo>() {
            @Override
            public UserInfo converData(Object[] obj) {
                UserInfo item = new UserInfo();
                item.setUid(NumberUtil.parseLong(obj[0], 0));
                item.setLevel(NumberUtil.parseInteger(obj[1], 0));
                item.setIntegral(NumberUtil.parseInteger(obj[2], 0));
                return item;
            }
        }, uid);
    }

    /**
     *
     * @param ids
     * @return
     */
    public List<User> getUsersByIdentity(String ids) {
        return find(SQL.User.getUsersByIdentity + " (" + ids + ")");
    }

}
