package com.bee.services.market.impl;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.market.AdDao;
import com.bee.modal.AdListItem;
import com.bee.pojo.market.Ad;
import com.bee.services.market.IAdService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Service
public class AdService implements IAdService {

    @Autowired
    private AdDao adDao;

    @Override
    public List<Ad> getAdList() {
        return adDao.getAdList();
    }

    @Override
    @Transactional
    public void addAd(Ad ad, MultipartFile file, HttpServletRequest req) throws DataRunException {
        try {
            String[] paths = ImageFactory.getInstance().saveImage(getImageType(ad.getType()), req, file);
            ad.setUrl(paths[0]);
            ad.setPath(paths[1]);
            ad.setCreateTime(System.currentTimeMillis());
            if (null == ad.getStopTime()) {
                ad.setStopTime(0l);
            }
            adDao.save(ad);
        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public List<AdListItem> getAppAdListByType(int type) {
        return adDao.getAppAdListByType(type);
    }


    private ImageFactory.ImageType getImageType(int type) {
        ImageFactory.ImageType imageType = null;
        if (type == Consts.Ad.Type.Home) {
            imageType = ImageFactory.ImageType.ShopAdSize;
        } else if (type == Consts.Ad.Type.Party) {
            imageType = ImageFactory.ImageType.PartyAdSize;
        }
        return imageType;
    }
}
