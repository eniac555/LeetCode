package com.myleetcode.a01array;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */

public class Array03 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] squares = sortedSquares(arr);
        for (int square : squares) {
            System.out.print(square + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            }
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return result;
    }
}
