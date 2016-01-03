package com.bee.dao.user.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.user.MessageDao;
import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 16/1/1.
 */
@Repository
public class MessageAppDao extends MessageDao {

    /**
     * 获取用户未读消息
     *
     * @param param
     * @return
     */
    public List<MessageList> getNewMessage(MessageParam param) {
        return findConverByParams(SQL.User.Message.GetNewMessage,
                new QueryDataConver<MessageList>() {
                    @Override
                    public MessageList converData(Object[] row) {
                        // A.MID, A.MSG, A.TYPE, A.CREATETIME, A.USER
                        MessageList item = new MessageList();
                        item.setMid(NumberUtil.parseLong(row[0], 0));
                        item.setMsg(StringUtil.parseString(row[1], ""));
                        item.setType(NumberUtil.parseInteger(row[2], Consts.User.Message.System));
                        item.setCreateTime(NumberUtil.parseLong(row[3], 0));
                        item.setUser(NumberUtil.parseLong(row[4], 0));
                        return item;
                    }
                }, param.getUid(), param.getLastUpdateTime());
    }

    /**
     * 删除指定用户所有消息
     *
     * @param userId
     * @throws DataRunException
     */
    public void deleteMessageByUser(Long userId) throws DataRunException {
        execute(SQL.User.Message.DeleteMessageByUser, userId);
    }
}
