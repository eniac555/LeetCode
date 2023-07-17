package com.myleetcode.a14others;

/**
 * @author eniac555
 * @date 2023/7/5
 * @description: 有效的山脉数组
 */
public class A02array {

    /*
    给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
    让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
    arr.length >= 3
    在 0 < i < arr.length - 1 条件下，存在 i 使得：
    arr[0] < arr[1] < ... arr[i-1] < arr[i]
    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }
        if (right == left && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }
}
