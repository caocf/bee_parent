package com.bee.client.params.find;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/6/13.
 */
public class FindReplyRequest extends PagingRequest {

    private static final long serialVersionUID = 417020411069618926L;

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
