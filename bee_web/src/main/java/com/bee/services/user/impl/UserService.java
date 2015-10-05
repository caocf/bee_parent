package com.bee.services.user.impl;

import com.bee.app.model.user.UserInfo;
import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.core.UserCacheFactory;
import com.bee.dao.user.UserDao;
import com.bee.image.ImageParser;
import com.bee.image.impl.UserAvatarImage;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.easemob.server.comm.Constants;
import com.easemob.server.comm.HTTPMethod;
import com.easemob.server.comm.Roles;
import com.easemob.server.httpclient.utils.HTTPClientUtils;
import com.easemob.server.httpclient.vo.ClientSecretCredential;
import com.easemob.server.httpclient.vo.Credential;
import com.easemob.server.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import com.qsd.framework.spring.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户业务实现类
 *
 * 2015.9.17
 * 更改用户头像实现, 使用ImageParser生成头像
 *
 * Created by suntongwei on 15/4/15.
 */
@Service
public class UserService implements IUserService {

    // LOG
    private final Logger Log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    /**
     *
     * @param account
     * @return
     */
    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    /**
     * 查询用户实时信息
     *
     * @param uid
     * @return
     */
    public UserInfo queryUserInfo(long uid) {
        return userDao.queryUserInfo(uid);
    }

    /**
     *
     * @param identity
     * @return
     */
    @Override
    public User getUserByIdentity(String identity) {
        return userDao.findById(Long.valueOf(identity) - Consts.User.IdentityBaseNum);
    }

    /**
     *
     *
     * @param identity
     * @return
     */
    @Override
    public List<User> getUsersByIdentity(String identity) {
        if (StringUtil.isNull(identity)) {
            return null;
        }
        String[] identitys = identity.split(",");
        String ids = "";
        for (String ide : identitys) {
            ids += "," + (Long.valueOf(ide) - Consts.User.IdentityBaseNum);
        }
        if (!StringUtil.isNull(ids)) {
            ids = ids.substring(1);
        }
        return userDao.getUsersByIdentity(ids);
    }

    /**
     * 注册一个新用户
     * 通知环信，加入环信用户体系
     *
     * @param user
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void createUser(User user) throws DataRunException {

        /**
         * 设置用户信息
         */
        user.setPassword(Md5.encodePassword(user.getPassword()));
        user.setType(Consts.User.Type.AppUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setIntegral(0);
        user.setLevel(0);
        user.setPath("");
        user.setUrl("");
        user.setCash(0d);
        userDao.save(user);

        /**
         * 注册IM用户[单个]
         * 给指定AppKey创建一个新的用户
         */
        Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username", user.getIdentity());
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        // 返回结果
        ObjectNode res = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, datanode,
                HTTPMethod.METHOD_POST);
        Log.debug("[HX_Response]Register:" + res.toString());

        // 把用户放入缓存
        UserCacheFactory.getInstance().put(user);
    }

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        return userDao.queryUserListByParams(req);
    }

    /**
     * 保存用户头像
     *
     * 2015.9.17
     * 更改图片创建实现
     *
     * @param uid 用户ID
     * @param file MultipartFile图片文件
     * @param req HttpServletRequest
     * @return
     * @throws RuntimeException
     */
    @Override
    @Transactional
    public User saveAvatar(Long uid, MultipartFile file, HttpServletRequest req) throws RuntimeException {
        User user = userDao.findById(uid);
        if (!file.isEmpty()) {
            // String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.UserImage, req, file);
            req.setAttribute(UserAvatarImage.USER_ID, uid);
            ImageParser imageParser = ImageParser.getImageParser(ImageParser.ImageType.UserAvatar);
            String[] paths = imageParser.generate(req, file);
            // 暂时不去除，可以无需再使用URL和PATH字段
            // 用户头像路径改为固定路径
            // 路径地址：/static/user/user_{userId}/avatar_720.jpg
            user.setUrl(paths[0]);
            user.setPath(paths[1]);
            userDao.update(user);
        }
        return user;
    }

    /**
     * 保存用户昵称
     *
     * @param uid
     * @param nickName
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveNickName(long uid, String nickName) throws DataRunException {
        User user = userDao.findById(uid);
        user.setName(nickName);
        userDao.update(user);
    }

}
