package com.myleetcode.a06stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1: 输入: "()" 输出: true
 * <p>
 * 示例 2: 输入: "()[]{}" 输出: true
 * <p>
 * 示例 3: 输入: "(]" 输出: false
 * <p>
 * 示例 4: 输入: "([)]" 输出: false
 */
public class Stack03 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                deque.push(']');
            } else if (c == '(') {
                deque.push(')');
            } else if (c == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || c != deque.peek()) {
                //此时遍历左括号，栈为空，返回false，栈顶元素不等于当前遍历到的字符串中的字符，返回false
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

}
