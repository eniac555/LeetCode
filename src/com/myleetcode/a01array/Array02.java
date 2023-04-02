package com.myleetcode.a01array;

/**
 * 给你一个数组 nums[]和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Array02 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12, 5, 6, 3};
        int i = removeElement(arr, 3);
        System.out.println(i);
    }


    //双指针，快指针也就是右指针进行遍历元素，左指针用于记录元素位置
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
