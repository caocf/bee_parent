package com.bee.services.find.app.impl;

import com.bee.dao.find.app.IFindAppDao;
import com.bee.domain.params.FindListParam;
import com.bee.modal.FindListItem;
import com.bee.services.find.app.IFindAppService;
import com.bee.services.find.impl.FindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class FindAppService extends FindService implements IFindAppService {

    @Autowired
    private IFindAppDao findDao;

    /**
     * @see com.bee.services.find.app.IFindAppService#queryFindList
     * @param param 查询参数
     * @return PagingResult<FindListItem>
     */
    @Override
    public PagingResult<FindListItem> queryFindList(FindListParam param) {
        return findDao.queryFindList(param);
    }
}
