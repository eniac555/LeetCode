package com.myleetcode.a06stackandqueue;

import java.util.Enumeration;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.empty());//true
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.peek());//7
        stack.pop();
        System.out.println(stack.peek());//6
        System.out.println(stack.isEmpty());//false
        System.out.println(stack.capacity());//10
        System.out.println(stack.empty());//false
        System.out.println(stack.search(6));//1
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println(Integer.MIN_VALUE);
    }
}
