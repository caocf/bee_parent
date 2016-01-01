package com.bee.domain.params.party;

import com.qsd.framework.domain.request.RequestPagingApp;

/**
 * Created by suntongwei on 15/12/31.
 */
public class PartyListParam extends RequestPagingApp {

    // serialVersionUID
    private static final long serialVersionUID = 4453435711467152870L;



    @Override
    public Integer getMaxRows() {
        return 10;
    }
}
