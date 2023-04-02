package com.myleetcode.a01array;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 */
public class Array04 {
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2, 3, 1, 2, 4, 3};
        int len = minSubArrayLen(target, arr);
        System.out.println(len);
    }

    //滑动窗口法
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                sum = sum - nums[left];
                result = Math.min(result, right - left + 1);
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
