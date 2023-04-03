package com.myleetcode.a02linklist;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LinkList04 {
    public static void main(String[] args) {

    }


    //双指针
    public static ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        ListNode temp;
        ListNode first;
        ListNode second;
        while (cur.next != null && cur.next.next != null) {
            //把需要用到的节点都定义出来
            temp = cur.next.next.next;//第二个节点后面的节点
            first = cur.next;
            second = cur.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = first;
        }
        return fakeHead.next;
    }


    //递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs(head.next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }
}
