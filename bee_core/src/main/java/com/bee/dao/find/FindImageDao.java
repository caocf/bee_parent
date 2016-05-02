package com.bee.dao.find;

import com.bee.pojo.find.FindImage;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/29.
 */
@Repository
public class FindImageDao extends JpaDaoSupport<FindImage, Long> {

    // DeleteFindImageByFindId
    public static final String DeleteFindImageByFindId = "DELETE FROM TB_FIND_IMAGE WHERE FIND = ?";

    /**
     * 根据发现ID删除所有发现图片
     *
     * @param findId
     * @throws DataRunException
     */
    public void deleteFindImageByFindId(long findId) throws DataRunException {
        execute(DeleteFindImageByFindId, findId);
    }

}
