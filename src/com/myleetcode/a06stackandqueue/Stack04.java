package com.myleetcode.a06stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 */
public class Stack04 {
    public static void main(String[] args) {

    }

    public static String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != c) {
                //当栈为空，或者栈顶元素不等于当前遍历的字符，就让遍历的字符进栈
                deque.push(c);
            } else {
                //当前遍历字符和栈顶元素相同，栈顶元素出栈
                deque.pop();
            }
        }
        String str = "";
        while (!deque.isEmpty()) {
            //栈内存放的是逆序，出栈后即为正常顺序
            str = deque.pop() + str;
        }
        return str;
    }
}
