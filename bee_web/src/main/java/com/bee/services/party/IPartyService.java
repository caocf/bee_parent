package com.bee.services.party;

import com.bee.client.params.party.AdminPartyRequest;
import com.bee.modal.PartyListItem;
import com.bee.pojo.party.Party;
import com.bee.pojo.party.PartyMeet;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/5/5.
 */
public interface IPartyService {

    /**
     *
     * @return
     */
    public List<Party> getPartyList();

    /**
     *
     * @return
     */
    public List<PartyListItem> getAppPartyList();

    /**
     *
     * @throws DataRunException
     */
    public void save(AdminPartyRequest req, HttpServletRequest request, MultipartFile file) throws DataRunException;
}
