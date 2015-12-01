package com.bee.services.find;

import com.bee.pojo.find.FindReply;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/12/1.
 */
public interface IFindReplyService {


    /**
     * 保存回复
     *
     * @param findReply
     * @throws DataRunException
     */
    void save(FindReply findReply) throws DataRunException;



}
