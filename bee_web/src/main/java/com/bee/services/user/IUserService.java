package com.bee.services.user;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/4/15.
 */
public interface IUserService {

    /**
     * 获取用户
     *
     * @param account
     * @return
     */
    public User getUserByAccount(String account);

    /**
     * 根据用户标识
     *
     * @param identity
     * @return
     */
    public User getUserByIdentity(String identity);

    /**
     * 创建注册用户
     *
     * @param user
     */
    public void createUser(User user) throws DataRunException;

    /**
     * 根据参数查询用户列表
     *
     * @param req
     * @return
     */
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req);

    /**
     * 保存用户头像
     */
    public void saveAvatar(Long uid, MultipartFile file, HttpServletRequest request) throws DataRunException;

    /**
     * 保存用户昵称
     *
     * @throws DataRunException
     */
    public void saveNickName(long uid, String nickName) throws DataRunException;
}
