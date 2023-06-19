package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/19
 * @description: 最小花费爬楼梯
 */
public class DP03 {
    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length + 1];
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            arr[i] = Math.min(arr[i - 1] + cost[i - 1], arr[i - 2] + cost[i - 2]);
        }
        return arr[cost.length];
    }
}
