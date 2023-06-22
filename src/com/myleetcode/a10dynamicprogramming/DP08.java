package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/22
 * @description: 二维数组01背包
 */
public class DP08 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    /**
     * 动态规划获得结果
     *
     * @param weight  物品重量
     * @param value   物品价值
     * @param bagSize 背包容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        //1.创建动规数组
        int[][] dp = new int[weight.length][bagSize + 1];//行表示的是物品个数，列表示的是背包当前容量

        //2.初始化动规数组
        //背包为0时即第一列，总价值肯定为0；第一行表示装第一个物品，除了容量为0时，其余初始值都为 value[0]；剩下整体其余值都初始为0
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }


        //打印dp数组
        System.out.println("数组初始化为：");
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        //3.计算并填充动规数组
        for (int i = 1; i < weight.length; i++) {//从1开始是因为0已经初始化好了
            for (int j = 1; j <= bagSize; j++) {//从1开始是因为0已经初始化好了，且可以等于最大容量，即恰好装满
                if (j < weight[i]) {
                    /*
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }


        //打印dp数组
        System.out.println("数组最终为：");
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        /*

        0	15	15	15	15
        0	15	15	20	35
        0	15	15	20	35

         */

    }
}
