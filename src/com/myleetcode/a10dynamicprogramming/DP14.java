package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 完全背包理论基础
 */
public class DP14 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testCompletePack01(weight, value, bagWeight);
    }

    /*

    完全背包与01背包的区别：
    1.完全背包可以对一个物品进行无限次拿取
    2.在遍历背包和物品时，都是顺序遍历，不用倒序，因为可以用多次
    3.先遍历背包还是先遍历物品没有影响，为了和前面一致并利于记忆，我还是先遍历物品吧哈哈哈...

     */


    //先遍历物品，再遍历背包
    public static void testCompletePack01(int[] weight, int[] value, int bagWeight) {
        //创建dp数组
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {//可以直接从j=weight[i]开始遍历，省去后面的条件判断
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        //打印看一下
        for (int i : dp) {
            System.out.println(i);
        }
    }


}
