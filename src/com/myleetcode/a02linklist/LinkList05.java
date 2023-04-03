package com.myleetcode.a02linklist;


/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LinkList05 {
    public static void main(String[] args) {

    }

    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0, head);
        // ListNode fast = new ListNode(0,head);
        // ListNode slow = new ListNode(0,head);
        ListNode fast = fakeHead;
        ListNode slow = fakeHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
