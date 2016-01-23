package com.bee.app.controller.travel;

import com.bee.app.travel.TravelChannelFactory;
import com.bee.app.travel.TravelGpsCache;
import com.bee.app.travel.bean.Channel;
import com.bee.app.travel.bean.GPS;
import com.bee.commons.Codes;
import com.bee.pojo.user.User;
import com.bee.services.user.app.IUserAppService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 16/1/18.
 */
@RestController
@RequestMapping("/travel")
public class TravelRoomController {

    @Autowired
    private IUserAppService userAppService;

    /**
     * 返回频道列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<Channel> getChannelList() {
        ResponseArray<Channel> res = new ResponseArray<>();
        res.setResult(TravelChannelFactory.getInstance().getChannel());
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 创建频道
     *
     * @param channel
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response createChannel(Channel channel, Long uid) {
        Response res = new Response();
        try {
            User user = userAppService.getUserById(uid);
            List<User> users = new ArrayList<>();
            users.add(user);
            channel.setUsers(users);
            channel.setCreateTime(System.currentTimeMillis());
            TravelChannelFactory.getInstance().addChannel(channel);
            res.setCode(Codes.Success);
        } catch (RuntimeException e) {
            res.setCode(Codes.Error);
            res.setMsg("已存在相同编号频道");
        }
        return res;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/{channelId}", method = RequestMethod.POST)
    public Response joinChannel(@PathVariable  Long channelId, Long uid) {
        Response res = new Response();
        User user = userAppService.getUserById(uid);
        if (null == user) {
            res.setCode(Codes.ParamsError);
            res.setMsg("未知用户");
            return res;
        }
        TravelChannelFactory.getInstance().joinChannel(channelId, user);
        res.setCode(Codes.Success);
        return res;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/{channelId}", method = RequestMethod.GET)
    public ResponseArray<GPS> getUserGps(@PathVariable  Long channelId) {
        ResponseArray<GPS> res = new ResponseArray<>();
        Channel channel = TravelChannelFactory.getInstance().getChannel(channelId);
        if (null == channel) {
            res.setCode(Codes.Error);
            res.setMsg("频道不存在");
        }
        List<User> user = channel.getUsers();
        res.setResult(TravelGpsCache.getInstance().getGPS(user));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     *
     * @param gps
     * @return
     */
    @RequestMapping(value = "/gps", method = RequestMethod.POST)
    public Response addUserGps(GPS gps) {
        Response res = new Response();
        gps.setCreateTime(System.currentTimeMillis());
        TravelGpsCache.getInstance().addGPS(gps);
        res.setCode(Codes.Success);
        return res;
    }
}
