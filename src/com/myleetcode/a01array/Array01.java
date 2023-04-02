package com.myleetcode.a01array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class Array01 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int result = search(arr, 5);
        System.out.println(result);
    }


    //二分查找
    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            if (target > nums[(max + min) / 2]) {
                min = (max + min) / 2 + 1;
            } else if (target < nums[(max + min) / 2]) {
                max = (max + min) / 2 - 1;
            } else {
                return (max + min) / 2;
            }
        }
        return -1;
    }

}
