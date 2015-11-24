package com.bee.dao.user;

import com.bee.admin.params.user.QueryUserParam;
import com.bee.app.model.user.UserInfo;
import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.SQL;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Repository
public class UserDao extends JpaDaoSupport<User, Long> {

    // LOG
    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    /**
     * @deprecated 使用{link getUserLoginByParam()}
     * @param account
     * @return
     */
    @Deprecated
    public User getUserByAccount(String account) {
        return findFirstByParams(SQL.User.queryUserByAccount, account);
    }

    /**
     * 通过昵称获取用户
     * v1.0.0版本BUG导致增加
     * 该版本会把nick当phone传入做密码修改
     *
     * @deprecated 使用{link getUserLoginByParam()}
     * @param nick 昵称
     * @return
     */
    @Deprecated
    public User getUserByNick(String nick) {
        return findFirstByParams(SQL.User.queryUserByNick, nick);
    }

    /**
     * <b>通过参数获取登录用户信息</b>
     * 该方法会返回一个适合登录使用的用户实体
     * 具体该实体会包含UserAuth的权限信息
     *
     * 如果参数中包含根据nick查询，查询结果可能有多条，但是该方法只会返回第一条，不建议使用nick进行查询
     * 如果参数中包含nick，则会在LOG中输出: Try not to use Nick
     *
     * @param param
     * @return
     */
    public User getUserLoginByParam(UserParam param) {
        HQLEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.GetUserLoginByParam);
        if (param != null) {
            if (!StringUtil.isNull(param.getPhone())) {
                sb.append(" and A.phone = ? ");
                entity.setParam(param.getPhone());
            }
            if (!StringUtil.isNull(param.getNick())) {
                sb.append(" and A.name = ? ");
                entity.setParam(param.getNick());
                LOG.error("Try not to use Nick");
            }
            if (param.getType() != null) {
                sb.append(" and A.type = ? ");
                entity.setParam(param.getType());
            }
        }
        entity.setEntity(sb);
        return querySingleResult(entity);
    }

    /**
     * <b>根据参数获取用户信息</b>
     * 该方法主要提供用户信息获取
     * 有区别于登录用户实体，该方法不提供UserAuth信息
     *
     * 如果参数中包含根据nick查询，查询结果可能有多条，但是该方法只会返回第一条，不建议使用nick进行查询
     * 如果参数中包含nick，则会在LOG中输出: Try not to use Nick
     *
     * @param param
     * @return
     */
    public User getUserByParam(UserParam param) {
        HQLEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.QueryUserByParams);
        if (param != null) {
            if (!StringUtil.isNull(param.getPhone())) {
                sb.append(" and A.phone = ? ");
                entity.setParam(param.getPhone());
            }
            if (!StringUtil.isNull(param.getNick())) {
                sb.append(" and A.name = ? ");
                entity.setParam(param.getNick());
                LOG.error("Try not to use Nick");
            }
            if (param.getType() != null) {
                sb.append(" and A.type = ? ");
                entity.setParam(param.getType());
            }
        }
        entity.setEntity(sb);
        return querySingleResult(entity);
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
        if (!StringUtil.isNull(req.getUserName())) {
            sb.append(" and A.name like %" + req.getUserName() + "%");
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

    /**
     * 根据参数查询用户列表
     *
     * @param param
     * @return
     */
    public List<User> queryUserByParams(QueryUserParam param) {

        // 创建查询实体
        HQLEntity entity = new HQLEntity();

        // 创建查询语句
        StringBuffer sb = new StringBuffer(SQL.User.QueryUserByParams);

        /**
         * 设置参数
         */
        if (param != null) {
            /**
             * 查询起始创建时间，根据用户注册时间开始计算
             */
            if (param.getStartCreateTime() != null) {
                sb.append(" and A.createTime >= ?");
                entity.setParams(param.getStartCreateTime());
            }
            /**
             * 根据用户类型查询
             */
            if (param.getType() != null) {
                sb.append(" and A.type = ?");
                entity.setParams(param.getType());
            }

            /**
             * 增加排序部分
             * 必须放在param最后
             */
            if (!StringUtil.isNull(param.getSortSection())) {
                sb.append(" ORDER BY ");
                sb.append(param.getSortSection());
            }
        }
        // 导入HQL
        entity.setEntity(sb);
        return queryResult(entity);
    }
}
