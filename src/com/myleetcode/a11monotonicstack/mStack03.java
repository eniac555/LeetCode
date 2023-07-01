package com.myleetcode.a11monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author eniac555
 * @date 2023/7/1
 * @description: 下一个更大元素 II
 */
public class mStack03 {
    /*
    题目要求：给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
            数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
            如果不存在，则输出 -1。

    解题思路：循环数组----可以对数组进行复制扩充，但是有点多余
                  ----可以直接遍历两次 for(int i = 0; i<2*length; i++)
            剩下的就和第一题每日温度一样了
     */

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < 2 * length; i++) {
            if (nums[i % length] <= nums[stack.peek()]) {
                stack.push(i % length);
            } else {
                while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i % length];
                    stack.pop();
                }
                stack.push(i % length);
            }
        }

        return result;
    }
}
