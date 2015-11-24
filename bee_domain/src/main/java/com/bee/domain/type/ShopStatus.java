package com.bee.domain.type;

/**
 * Created by suntongwei on 15/11/17.
 */
public enum ShopStatus {

    Run(1),
    // 由商家关闭
    Pause(2),
    // 管理员关闭
    Stop(0);

    private int status;

    private ShopStatus(int val) {
        status = val;
    }

    public int getStatus() {
        return status;
    }

}
