package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/19
 * @description: 斐波那契数列
 */
public class DP01 {

    public int fib(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
