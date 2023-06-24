package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 爬楼梯--进阶版
 */
public class DP17 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5, 3));
    }
    /*

    改为：一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？

    貌似和上一个题一模一样了

     */


    /**
     * 爬楼梯
     *
     * @param n 楼梯总数
     * @param m 可选每次爬的步数
     * @return 爬 n 层楼梯，每次最多爬 m 层，共有多少方式
     */
    public static int climbStairs(int n, int m) {
        //创建dp数组
        int[] dp = new int[n + 1];
        //初始化dp数组
        dp[0] = 1;
        //遍历dp数组--由于{1,2}和{2,1}是两种组合，所以先遍历背包，再遍历物品
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= j) {
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }
        return dp[n];
    }


}
