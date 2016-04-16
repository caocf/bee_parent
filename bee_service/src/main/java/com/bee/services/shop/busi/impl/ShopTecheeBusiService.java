package com.bee.services.shop.busi.impl;

import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.commons.Consts;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.domain.modal.app.shop.ShopTecheeItem;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.bee.services.shop.impl.ShopTecheeService;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopTecheeBusiService extends ShopTecheeService implements IShopTecheeBusiService {

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<BusiShopTechee> getShopTecheeByShopId(long shopId) {
        return shopTecheeDao.getShopTecheeByShopId(shopId);
    }

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    @Override
    public List<ShopTecheeItem> getShopTecheeByGroupId(long gid) {
        return shopTecheeDao.getShopTecheeByGroupId(gid);
    }

    /**
     * 更新一个技师
     *
     * @param shopTechee
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void updateShopTechee(ShopTechee shopTechee) throws DataRunException {
        shopTecheeDao.update(shopTechee);
    }

    /**
     * 保存商家技师出勤表
     *
     * @param sid
     * @param attends
     */
    @Override
    @Transactional
    public void saveTecheeAttend(Long sid, String attends) throws DataRunException {
        try {
            // 设置所有技师都不出勤
            shopTecheeDao.updateTecheeAttendToFalse(sid);
            // 更新出勤技师
            shopTecheeDao.updateShopTecheeAttend(attends);
        } catch (DataRunException e) {
            throw e;
        }
    }
}
