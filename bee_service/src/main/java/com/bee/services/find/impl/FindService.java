package com.bee.services.find.impl;

import com.bee.commons.Consts;
import com.bee.dao.find.FindDao;
import com.bee.dao.find.FindImageDao;
import com.bee.dao.find.FindReplyDao;
import com.bee.pojo.find.Find;
import com.bee.services.find.IFindService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public abstract class FindService implements IFindService {

    @Autowired
    protected FindDao findDao;
    @Autowired
    protected FindImageDao findImageDao;
    @Autowired
    protected FindReplyDao findReplyDao;

    /**
     * 保存发布发现
     *
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void save() throws DataRunException {

    }

    /**
     * 删除发现
     *
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void delete(long findId) throws DataRunException {
        // 获取Find
        Find find = findDao.findById(findId);
        // 删除TB_FIND_REPLY
        findReplyDao.deleteFindReplyByFindId(findId);
        // 如果类型是ShopPop, 则删除TB_FIND_IMAGE
        if (find.getType() == Consts.Find.Type.ShopPop) {
            findImageDao.deleteFindImageByFindId(findId);
        }
        // 最后删除发现
        findDao.delete(find);
    }
}
