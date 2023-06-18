package com.myleetcode.a09greed;

/**
 * @author eniac555
 * @date 2023/6/10
 * @description:
 */
public class Greed10 {

    /**
     * 情况一：账单是5，直接收下。
     * 情况二：账单是10，消耗一个5，增加一个10
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     * @param bills 账单
     * @return boolean
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
            // 这里并不用判断ten<0吧，ten永远都是大于等于0的
        }

        return true;
    }
}
