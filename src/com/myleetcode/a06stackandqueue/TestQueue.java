package com.myleetcode.a06stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.peek());//10
        System.out.println(queue.poll());//10
        System.out.println(queue.peek());//20
        System.out.println(queue.isEmpty());//false
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println(queue.offer(40));//true
    }


}
