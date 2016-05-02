package com.bee.dao.find;

import com.bee.pojo.find.FindReply;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/13.
 */
@Repository
public class FindReplyDao extends JpaDaoSupport<FindReply, Long> {

    // DeleteFindReplyByFindId
    public static final String DeleteFindReplyByFindId = "DELETE FROM TB_FIND_REPLY WHERE FIND = ?";

    /**
     * 根据发现ID删除所有回复
     *
     * @param findId
     * @throws DataRunException
     */
    public void deleteFindReplyByFindId(long findId) throws DataRunException {
        execute(DeleteFindReplyByFindId, findId);
    }


}
