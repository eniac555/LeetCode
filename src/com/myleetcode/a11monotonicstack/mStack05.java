package com.myleetcode.a11monotonicstack;

import java.util.Stack;

/**
 * @author eniac555
 * @date 2023/7/1
 * @description: 柱状图中最大的矩形
 */
public class mStack05 {
    /*
    本题是找每个柱子左右两边 第一个小于 该柱子的柱子----栈内(栈顶-->栈底)单调递减

    小技巧：数组尾部都加上0，是为了防止类似于{2, 4, 6, 8}这样的数组，只入栈，没有相应的计算---
          如果数组本身就是升序的，例如[2,4,6,8]，那么入栈之后 都是单调递减，
          一直都没有走 情况三 计算结果的哪一步，所以最后输出的就是0了。

          数组头部加上0，是为了防止类似[8,6,4,2]，在 8 入栈后，6 开始与8 进行比较，此时我们得到 mid（8），rigt（6），
          但是得不到 left。（mid、left，right 都是对应版本一里的逻辑）
          因为 将 8 弹出之后，栈里没有元素了，那么为了避免空栈取值，直接跳过了计算结果的逻辑。

     */

    //单调栈方法
    public int largestRectangleArea(int[] heights) {
        //存储结果
        int result = 0;
        //数组扩容，首尾加0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }

        //定义单调栈
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < newHeights.length; i++) {
            //方便理解，没有合并
            if (newHeights[i] > newHeights[stack.peek()]) stack.push(i);//当前元素大于栈顶元素，入栈
            else if (newHeights[i] == newHeights[stack.peek()]) stack.push(i);//当前元素等于栈顶元素，也入栈
            else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    Integer mid = stack.peek();//当前栈顶为中间的元素
                    stack.pop();//出栈后新的栈顶就是中间元素的左边第一个比它小的元素
                    int w = i - stack.peek() - 1;//宽度
                    int h = newHeights[mid];//高度
                    result = Math.max(result, w * h);//更新结果
                }
                stack.push(i);
            }
        }

        return result;
    }


    //暴力解法
    public int largestRectangleArea2(int[] heights) {
        int length = heights.length;
        int[] minLeftIndex = new int[length];
        int[] minRightIndex = new int[length];
        // 记录左边第一个小于该柱子的下标
        minLeftIndex[0] = -1;
        for (int i = 1; i < length; i++) {
            int t = i - 1;
            // 这里不是用if，而是不断向右寻找的过程
            while (t >= 0 && heights[t] >= heights[i]) t = minLeftIndex[t];
            minLeftIndex[i] = t;
        }
        // 记录每个柱子右边第一个小于该柱子的下标
        minRightIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < length && heights[t] >= heights[i]) t = minRightIndex[t];
            minRightIndex[i] = t;
        }
        // 求和
        int result = 0;
        for (int i = 0; i < length; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }


}
