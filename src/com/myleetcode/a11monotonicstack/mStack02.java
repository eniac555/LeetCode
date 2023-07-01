package com.myleetcode.a11monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author eniac555
 * @date 2023/7/1
 * @description: 下一个更大元素 I
 */
public class mStack02 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    /*
    题目要求：
    给你两个 <没有重复元素> 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
    请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

    解题思路：
    下一个更大元素：所以从栈顶到栈底为递增的，且存放的是nums2的下标
    整体思路：1.创建大小和nums1一致的结果数组
            2.因为无重复，可以用map存储nums1
            3.以单调递增栈的方式遍历nums2，遇到当前遍历元素大于栈顶元素，就看看在nums1中有没有该栈顶元素
            4.如果有，记录下当前遍历到的这个元素，栈顶元素出栈，再判断新的栈顶元素
            5.不满足遍历元素大于栈顶元素，当前遍历元素进栈
     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //存结果且初始化为-1
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        //建立栈
        Stack<Integer> stack = new Stack<>();
        //建立map，并存入元素
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);//因为后面是用元素值判断，所以key值应该存真实元素值，而不是索引
        }
        //先把nums2的第一个元素入栈----存索引
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {//索引0已经进去了，所以从1开始
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        Integer index = map.get(nums2[stack.peek()]);
                        result[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return result;

    }
}
