package com.bee.commons;

/**
 * 等级计算器
 *
 * Created by suntongwei on 15/10/5.
 */
public class LevelMachine {

    /**
     * 完成订单获得经验
     */
    public static final int OrderFinish = 100;

    /**
     * 完成订单评论经验
     */
    public static final int OrderComment = 20;


    public static final int Exp1 = 500;
    public static final int Exp2 = 1000;


    /**
     * 根据EXP经验返回响应等级
     *
     * @return
     */
    public static int GetLevel(int exp) {
        if (exp >= Exp1) {
            return 1;
        } else if (exp >= Exp2) {
            return 2;
        }
        return 0;
    }

}
