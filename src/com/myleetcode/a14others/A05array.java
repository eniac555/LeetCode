package com.myleetcode.a14others;

/**
 * @author eniac555
 * @date 2023/7/5
 * @description: 旋转数组
 */
public class A05array {

    /*
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    示例 1:
    输入: nums = [1,2,3,4,5,6,7], k = 3
    输出: [5,6,7,1,2,3,4]
     */

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
