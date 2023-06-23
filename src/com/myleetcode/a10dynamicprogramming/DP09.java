package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/22
 * @description: 一维滚动数组0-1背包
 */
public class DP09 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        //1.创建dp数组
        int[] dp = new int[bagWeight + 1];

        //2.不用额外初始化，因为默认创建数组默认初始化0，和预期要求的一致了

        //3.计算并填充dp数组
        for (int i = 0; i < weight.length; i++) {//只能先遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) {//必须倒序遍历，倒序遍历是为了保证物品i只被放入一次
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        //打印dp数组
        for (int j : dp) {
            System.out.println(j + " ");
        }
    }
}
