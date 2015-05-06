package com.bee.services.party.impl;

import com.bee.client.params.party.AdminPartyRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.party.PartyDao;
import com.bee.dao.party.PartyMeetDao;
import com.bee.modal.PartyListItem;
import com.bee.pojo.party.Party;
import com.bee.pojo.party.PartyMeet;
import com.bee.services.party.IPartyService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/5/5.
 */
@Service
public class PartyService implements IPartyService {

    @Autowired
    private PartyDao partyDao;
    @Autowired
    private PartyMeetDao partyMeetDao;

    @Override
    public List<Party> getPartyList() {
        return partyDao.getPartyList();
    }

    @Override
    public List<PartyListItem> getAppPartyList() {
        return partyDao.getAppPartyList();
    }

    @Override
    @Transactional
    public void save(AdminPartyRequest req, HttpServletRequest request, MultipartFile file) throws DataRunException {
        try {
            Party party = req.getParty();
            if(file != null) {
                String[] paths = ImageFactory.getInstance().saveImage(
                        ImageFactory.ImageType.PartyMainSize, request, file);
                party.setUrl(paths[0]);
                party.setPath(paths[1]);
            }
            PartyMeet meet = req.getMeet();
            partyMeetDao.save(meet);
            party.setType(Consts.Party.Type.Offline);
            party.setChildId(meet.getPmid());
            party.setLookNum(0);
            party.setCreateTime(System.currentTimeMillis());
            partyDao.save(party);
        } catch(DataRunException e) {
            if(file != null && !StringUtil.isNull(req.getParty().getPath())) {
                ImageFactory.getInstance().deleteImage(req.getParty().getPath());
            }
            throw e;
        }
    }
}
