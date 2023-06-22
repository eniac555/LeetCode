package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/21
 * @description:
 */
public class DP07 {

    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


    public int numTrees2(int n) {
        //这题不好想啊，递推公式不一定能想出来，不一定能想到动态规划
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] = arr[i] + arr[j - 1] * arr[i - j];
            }
        }
        return arr[n];
    }

}
