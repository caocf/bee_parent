package com.bee.app.controller.user;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.bee.services.user.admin.IUserAdminService;
import com.bee.sms.SMSCodeFactory;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import com.qsd.framework.spring.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/16.
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private IUserAdminService userAdminService;

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/{uid}/edit/pass", method = RequestMethod.PATCH)
    public Response editPass(@PathVariable Long uid, String oldPass, String newPass, String phone) {
        Response res = new Response();
        try {
            User user;
            // 通过手机找回密码修改
            if (!StringUtil.isNull(phone)) {
                if (phone.length() != 11) {
                    res.setCode(Codes.Error);
                    res.setMsg("未知手机号");
                    return res;
                }
                if (!"isPassFind".equals(oldPass)) {
                    res.setCode(Codes.Error);
                    res.setMsg("参数错误");
                    return res;
                }
                UserParam param = new UserParam();
                param.setPhone(phone);
                param.setType(Consts.User.Type.AppUser);
                user = userAdminService.getUserByParam(param);
            } else {
                user = userAdminService.getUserById(uid);
            }
            if (user != null) {
                if (StringUtil.isNull(phone) && Md5.encodePassword(oldPass).equals(user.getPassword())) {
                    // 如果手机为空，则表示修改密码，需要输入原密码
                    user.setPassword(Md5.encodePassword(newPass));
                    userAdminService.editUser(user);
                    res.setCode(Codes.Success);
                } else if (!StringUtil.isNull(phone)) {
                    // 如果手机不为空，则标识通过手机找回密码，不需要判断旧密码是否正确
                    user.setPassword(Md5.encodePassword(newPass));
                    userAdminService.editUser(user);
                    res.setCode(Codes.Success);
                } else {
                    res.setCode(Codes.Error);
                    res.setMsg("原密码错误");
                }
            } else {
                res.setCode(Codes.Error);
                res.setMsg("未知用户");
            }
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("修改失败，请重试");
        }
        return res;
    }
}
