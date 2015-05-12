package com.bee.services.market;

import com.bee.modal.AdListItem;
import com.bee.pojo.market.Ad;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
public interface IAdService {

    /**
     * 查询广告列表
     *
     * @return
     */
    public List<Ad> getAdList();

    /**
     * 增加一个广告
     *
     * @param ad
     * @throws DataRunException
     */
    public void addAd(Ad ad, MultipartFile file, HttpServletRequest req) throws DataRunException;

    /**
     * 根据类型查询APP广告集合
     *
     * @param type
     * @return
     */
    public List<AdListItem> getAppAdListByType(int type);

    /**
     *
     *
     * @param updateTime
     * @return
     */
    public List<AdListItem> getAppAdListByUpdateTime(long updateTime);
}
