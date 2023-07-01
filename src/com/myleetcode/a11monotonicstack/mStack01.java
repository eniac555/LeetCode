package com.myleetcode.a11monotonicstack;

import java.util.Stack;

/**
 * @author eniac555
 * @date 2023/7/1
 * @description: 每日温度
 */
public class mStack01 {
    /*

    单调栈：以空间换时间
    单调：指的是从栈顶到栈低，按照单调的顺序，因为区元素必须在栈顶----先这么理解吧，事是这么个事，但是貌似解释的不全对
    栈内元素：存的是元素下标，用到元素值时直接根据下标从数组里面取就行
    本题要找到右边第一个比自己大的元素，应该 栈顶-->栈底 单调递增

    需要判断三种情况：当前元素大于栈顶元素---栈顶元素出栈，计算结果，继续判断新的栈顶元素
                  当前元素等于栈顶元素---当前元素入栈
                  当前元素小于栈顶元素---当前元素入栈
                  -----有了这个就可以解决了-----
     */

    public int[] dailyTemperatures(int[] temperatures) {
        //创建栈
        Stack<Integer> stack = new Stack<>();

        //创建存结果的数组
        int[] result = new int[temperatures.length];

        stack.push(0);//这里进去的是第一个元素的索引

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {//对应情况2和3
                stack.push(i);
            } else {
                // 可能当前元素连续大于栈内的元素，所以用while循环，同时防止栈为空
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    //获取结果
                    result[stack.peek()] = i - stack.peek();
                    //得到了结果后就出栈
                    stack.pop();
                }
                // 不满足条件了(栈为空 或者 当前元素值小于等于栈顶元素值)，需要当前元素进栈
                stack.push(i);

            }
        }

        return result;
    }
}
