package com.bee.services.find;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * <b>发现业务接口</b>
 *
 * @since v1.1.0
 */
public interface IFindService {

    /**
     * 保存发布发现
     *
     * @throws DataRunException
     */
    void save() throws DataRunException;

    /**
     * 删除发现
     *
     * @param findId 发现ID
     * @throws DataRunException
     */
    void delete(long findId) throws DataRunException;
}
