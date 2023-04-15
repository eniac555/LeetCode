package com.myleetcode.a06stackandqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        /*Queue<Integer> queue = new LinkedList<>();
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
        System.out.println(queue.offer(40));//true*/

        PriorityQueue<Integer> queue1 = new PriorityQueue<>((n1,n2)->(n1-n2));//类似于小顶堆
        queue1.add(1);
        queue1.add(5);
        queue1.add(6);
        queue1.add(8);
        queue1.add(3);
        queue1.add(12);
        queue1.add(7);
        queue1.add(2);
        int size = queue1.size();
        for (int i = 0; i < size; i++) {
            Integer poll = queue1.poll();
            System.out.print(poll+" ");
        }
        System.out.println();

        System.out.println("======================");

        PriorityQueue<Integer> queue2 = new PriorityQueue<>((n1,n2)->(n2-n1));//类似于大顶堆
        queue2.add(1);
        queue2.add(5);
        queue2.add(6);
        queue2.add(8);
        queue2.add(3);
        queue2.add(12);
        queue2.add(7);
        queue2.add(2);
        int size2 = queue2.size();
        for (int i = 0; i < size2; i++) {
            Integer poll = queue2.poll();
            System.out.print(poll+" ");
        }



    }


}
