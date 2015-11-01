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
    public static final int OrderFinish = 1000;

    /**
     * 完成订单评论经验
     */
    public static final int OrderComment = 200;

    /**
     * 评论经验
     */
    public static final int Comment = 10;


    public static final int Exp1 = 1000;
    public static final int Exp2 = 6000;
    public static final int Exp3 = 12000;
    public static final int Exp4 = 19000;
    public static final int Exp5 = 27000;
    public static final int Exp6 = 36000;


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
        } else if (exp >= Exp3) {
            return 3;
        } else if (exp >= Exp4) {
            return 4;
        } else if (exp >= Exp5) {
            return 5;
        } else if (exp >= Exp6) {
            return 6;
        }
        return 0;
    }

}
