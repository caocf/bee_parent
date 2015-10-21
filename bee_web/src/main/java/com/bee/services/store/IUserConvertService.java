package com.bee.services.store;

import com.bee.app.model.store.UserConvertListItem;
import com.bee.app.params.store.UserConvertQueryRequest;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/10/21.
 */
public interface IUserConvertService {


    /**
     * 兑换商品
     *
     * @param uid
     * @param goodsId
     */
    public void saveUserConvert(long uid, long goodsId) throws DataRunException;

    /**
     * 查询兑换记录
     *
     * @return
     */
    public PagingResult<UserConvertListItem> queryUserConverList(UserConvertQueryRequest req);

}
