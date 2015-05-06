package com.bee.dao.party;

import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.PartyListItem;
import com.bee.pojo.party.Party;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/5.
 */
@Repository
public class PartyDao extends JpaDaoSupport<Party, Long> {

    /**
     * 查询活动列表
     *
     * @return
     */
    public List<Party> getPartyList() {
        return find(SQL.Party.getPartyList);
    }

    /**
     * 获取APP活动列表
     *
     * @return
     */
    public List<PartyListItem> getAppPartyList() {
        return findConverByParams(SQL.Party.getAppPartyList, new QueryDataConver<PartyListItem>() {
            @Override
            public PartyListItem converData(Object[] obj) {
                PartyListItem item = new PartyListItem();
                item.setPid(NumberUtil.parseLong(obj[0], 0));
                item.setImage(new ImageFactory.Image(
                        StringUtil.parseString(obj[1], null), ImageFactory.ImageType.ShopMainSize));
                item.setLookNum(NumberUtil.parseInteger(obj[2], 0));
                item.setExplain(StringUtil.parseString(obj[3], ""));
                return item;
            }
        }, System.currentTimeMillis(), System.currentTimeMillis());
    }
}
