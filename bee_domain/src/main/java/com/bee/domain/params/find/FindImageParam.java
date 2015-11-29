package com.bee.domain.params.find;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 15/11/29.
 */
public class FindImageParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = 373101155013636777L;

    // 发现ID
    private Long findId;

    public Long getFindId() {
        return findId;
    }
    public void setFindId(Long findId) {
        this.findId = findId;
    }
}
