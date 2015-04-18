package com.bee.dao.shop;

import com.bee.client.params.shop.ShopErrorRequest;
import com.bee.commons.Consts;
import com.bee.pojo.shop.ShopError;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author admin
 */
@Repository
public class ShopErrorDao extends JpaDaoSupport<ShopError, Long> {

	
	public PagingResult<ShopError> queryShopError(ShopErrorRequest query) {
		String queryStr = "From ShopError A left join fetch A.shop B where 1=1";
		HQLEntity entity = new HQLEntity();
		if(query.getStatus() != null && query.getStatus() > 0) {
			queryStr += " and A.status = ?";
			entity.setParam(query.getStatus());
		} else {
			queryStr += " and A.status <> ?";
			entity.setParam(Consts.Shop.ErrorStatus.End);
		}
		if(query.getShopId() != null) {
			queryStr += " and B.sid = ?";
			entity.setParam(query.getShopId());
		}
		if(!StringUtil.isNull(query.getShopName())) {
			queryStr += " and B.name = ?";
			entity.setParam(query.getShopName());
		}
		entity.setPaging(query);
		entity.setEntity(queryStr);
		return queryWithPaging(entity);
	}
	
	public void updateShopErrorStatus(long id, int status) throws DataRunException {
		HQLEntity entity = new HQLEntity("update ShopError A set A.status = ? where A.shopErrorId = ?");
		entity.setParams(status, id);
		execute(entity);
	}
}
