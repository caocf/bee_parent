package com.bee.domain.params.find;

import com.qsd.framework.domain.request.RequestPagingApp;

/**
 * Created by suntongwei on 15/12/1.
 */
public class FindReplyParam extends RequestPagingApp {

    // serialVersionUID
    private static final long serialVersionUID = 770645677622217377L;

    private Long findId;

    public Long getFindId() {
        return findId;
    }
    public void setFindId(Long findId) {
        this.findId = findId;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
