package com.bee.services.user;

import com.bee.app.model.user.UserInfo;
import com.bee.client.params.user.AdminUserListRequest;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * 通过昵称获取用户
     * v1.0.0版本BUG导致增加
     * 该版本会把nick当phone传入做密码修改
     *
     * @return
     */
    public User getUserByNick(String nick);


    /**
     * 根据ID获取用户
     *
     * @param uid
     * @return
     */
    public User getUserById(long uid);

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<User> getAllUser();

    /**
     * 查询用户实时信息
     *
     * @param uid
     * @return
     */
    public UserInfo queryUserInfo(long uid);

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
     * 保存用户头像
     */
    public User saveAvatar(Long uid, MultipartFile file, HttpServletRequest request) throws DataRunException;

    /**
     * 保存用户昵称
     *
     * @throws DataRunException
     */
    public void saveNickName(long uid, String nickName) throws DataRunException;


    /**
     * 用户更新
     *
     * @param user
     * @throws DataRunException
     */
    public void editUser(User user) throws DataRunException;
}
