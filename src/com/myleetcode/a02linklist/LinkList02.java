package com.myleetcode.a02linklist;

/**
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 *      如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 *      如果 index 大于链表长度，则不会插入节点。
 *      如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class LinkList02 {
    int size;
    ListNode head;//虚拟头结点，不是真头结点

    //初始化链表
    public LinkList02() {
        size = 0;
        head = new ListNode(0);

    }

    //根据索引返回值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head;
        for (int i = 0; i <= index; i++) {//包含了虚拟头结点，其索引为0
            current = current.next;
        }
        return current.val;
    }


    //在原有头结点之前插入新节点，作为新的头结点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }


    public void addAtTail(int val) {
        addAtIndex(size, val);
    }


    //下指定下标的节点之前插入新节点
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size = size + 1;
        //找到current的前一个节点
        ListNode preCurrent = head;
        for (int i = 0; i < index; i++) {
            preCurrent = preCurrent.next;
        }
        //下面找到current
        ListNode current = preCurrent.next;
        //定义要插入的节点
        ListNode insert = new ListNode(val, current);
        preCurrent.next = insert;

    }

    //删除下标为index的节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size = size - 1;
        if (index == 0) {
            head = head.next;
            return;
        }
        //找到current的前一个节点
        ListNode preCurrent = head;
        for (int i = 0; i < index; i++) {
            preCurrent = preCurrent.next;
        }
        //下面找到current后驱节点
        preCurrent.next = preCurrent.next.next;

    }
}
