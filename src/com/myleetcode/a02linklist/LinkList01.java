package com.myleetcode.a02linklist;


import java.util.LinkedList;

/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class LinkList01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();


    }

    public static ListNode removeElements(ListNode head, int val) {
        //先确定好满足条件的头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        //再删除其他值为val的元素
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;

        }
        return head;
    }
}
