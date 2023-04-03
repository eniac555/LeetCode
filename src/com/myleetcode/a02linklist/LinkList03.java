package com.myleetcode.a02linklist;

/**
 * 反转一个单链表。
 */
public class LinkList03 {
    public static void main(String[] args) {

    }


    //双指针
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    //递归
    public static ListNode reverseList2(ListNode head) {
        return reverse(null,head);
    }

    public static ListNode reverse(ListNode prev, ListNode cur){
        if(cur==null){
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        return reverse(cur,temp);
    }


}
