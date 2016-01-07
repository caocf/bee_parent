package com.bee.dao.user.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.user.MessageDao;
import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
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
    public List<MessageList> getUserMessage(MessageParam param) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.User.Message.GetUserMessage);
        if (param.getUid() != null && param.getUid() > 0) {
            sb.append(" AND A.USER = ?");
            entity.setParam(param.getUid());
        }
        if (param.getStatus() != null) {
            sb.append(" AND A.STATUS = ?");
            entity.setParam(param.getStatus());
        }
        entity.setQueryDataConver(new QueryDataConver<MessageList>() {
            @Override
            public MessageList converData(Object[] row) {
                MessageList item = new MessageList();
                item.setMid(NumberUtil.parseLong(row[0], 0));
                item.setMsg(StringUtil.parseString(row[1], ""));
                item.setType(NumberUtil.parseInteger(row[2], Consts.User.Message.Type.System));
                item.setCreateTime(NumberUtil.parseLong(row[3], 0));
                item.setUser(NumberUtil.parseLong(row[4], 0));
                item.setStatus(NumberUtil.parseInteger(row[5], Consts.User.Message.Status.UnRead));
                return item;
            }
        });
        entity.setEntity(sb);
        return queryResultConver(entity);
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
