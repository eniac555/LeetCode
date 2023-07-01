package com.myleetcode.a11monotonicstack;

import java.util.Stack;

/**
 * @author eniac555
 * @date 2023/7/1
 * @description: 接雨水
 */
public class mStack04 {

    /*
    单调栈:
    思路：还是一个递增栈(栈顶-->栈底)，根据当前遍历元素和栈顶元素进行比较判断
         当前遍历元素 < 栈顶元素，直接进栈
         当前遍历元素 = 栈顶元素，有两种操作：1.直接进栈，下次求面积对应结果为0；2：栈顶元素出栈，当前元素进栈---两者效果是一样的
         当前遍历元素 > 栈顶元素：意味着找到了栈顶元素右边第一个比他大的元素，然后左边第一个比他大的元素是当前栈中栈顶元素的下一个元素，
                             因为是单调栈，所以栈顶的下一个元素一定是大于等于栈顶元素
                             (相等计算出结果也是0，这也是为什么相等时两种操作结果一样)
                             有了左右两边各自比当前元素大的元素，就能计算面积了----注意是横着算的面积，即在行方向上进行计算
     */
    public int trap(int[] height) {
        int result = 0;
        int length = height.length;
        if (length <= 2) return result;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) stack.push(i);
            else if (height[i] == height[stack.peek()]) {
                stack.push(i);//这里直接进栈了，可以和上面进行合并
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer peek = stack.peek();//记录中间元素坐标
                    stack.pop();//出栈后，新的栈顶元素就是左边第一个比他大的元素
                    if (!stack.isEmpty()) {//由于进行了出栈，所以需要判空
                        int h = Math.min(height[i], height[stack.peek()]) - height[peek];
                        int w = i - stack.peek() - 1;
                        result = result + h * w;
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }


    /*
    暴力解法：按列求的结果---每次遍历都找到当前遍历元素左右两边各自最大的元素值
     */
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i == 0 || i == height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }


    /*
    双指针：按列求的结果---先遍历数组，找到左右两边各自最大的元素，存到两个数组里，后面直接用，而不是每次遍历都循环找一次最大值
     */
    public int trap3(int[] height) {
        int length = height.length;
        if (length <= 2) return 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);

        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) maxRight[i] = Math.max(height[i], maxRight[i + 1]);

        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }
}
