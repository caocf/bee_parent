package com.bee.services.shop.busi;

import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopTecheeBusiService extends IShopTecheeService {

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    List<BusiShopTechee> getShopTecheeByShopId(long shopId);

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    List<ShopTechee> getShopTecheeByGroupId(long gid);

    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void saveShopTechee(ShopTechee shopTechee) throws DataRunException;

    /**
     * 更新一个技师
     *
     * @param shopTechee
     * @throws DataRunException
     */
    void updateShopTechee(ShopTechee shopTechee) throws DataRunException;

    /**
     * 删除一个技师
     *
     * @param id
     * @throws DataRunException
     */
    void deleteShopTechee(long id) throws DataRunException;

    /**
     * 查询商家技师出勤表
     *
     * @param sid 商家ID
     * @return
     */
    List<ShopTecheeAttend> queryShopTecheeAttend(Long sid);

    /**
     * 保存商家技师出勤表
     *
     * @param sid
     * @param attends
     */
    void saveTecheeAttend(Long sid, String attends) throws DataRunException;
}
