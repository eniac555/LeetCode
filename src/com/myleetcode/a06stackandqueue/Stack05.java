package com.myleetcode.a06stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", " * "]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 */
public class Stack05 {
    //逆波兰表达式：是一种后缀表达式，所谓后缀就是指运算符写在后面
    public static void main(String[] args) {
        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));
    }


    public static int evalRPN(String[] tokens) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("+")) {
                queue.push(queue.pop() + queue.pop());
            } else if (c.equals("-")) {
                queue.push(-queue.pop() + queue.pop());
            } else if (c.equals("*")) {
                queue.push(queue.pop() * queue.pop());
            } else if (c.equals("/")) {
                int temp1 = queue.pop();
                int temp2 = queue.pop();
                queue.push(temp2 / temp1);
            } else {
                queue.push(Integer.valueOf(c));
            }
        }
        return queue.pop();
    }
}
